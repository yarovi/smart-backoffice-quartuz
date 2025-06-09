package org.inamsay.net;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Provider
public class SmartExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        // 🎯 Caso 1: Error de validación de Bean (DTO con @Valid)
        if (exception instanceof ConstraintViolationException validationEx) {
            List<Violation> violations = validationEx.getConstraintViolations().stream()
                    .map(v -> new Violation(v.getPropertyPath().toString(), v.getMessage()))
                    .collect(Collectors.toList());

            ErrorResponse error = new ErrorResponse("Constraint Violation", 400, violations);

            return Response.status(Response.Status.BAD_REQUEST)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(error)
                    .build();
        }

        // 🎯 Caso 2: Restricción de base de datos (clave única, FK, etc.)
        if (isCauseHibernateConstraintViolation(exception)) {
            ConstraintViolationException hibernateEx =
                    (ConstraintViolationException) getDeepCause(exception);

            List<Violation> violations = new ArrayList<>();
            violations.add(new Violation("database", "Unique constraint or FK violation: " + hibernateEx.getMessage()));

            ErrorResponse error = new ErrorResponse("Database Constraint Violation", 409, violations);

            return Response.status(Response.Status.CONFLICT)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(error)
                    .build();
        }

        // ❗ Caso 3: Error genérico no controlado
        ErrorResponse error = new ErrorResponse("Internal Server Error", 500, List.of(
                new Violation("exception", exception.getMessage())
        ));

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON)
                .entity(error)
                .build();
    }

    private boolean isCauseHibernateConstraintViolation(Throwable e) {
        return getDeepCause(e) instanceof ConstraintViolationException;
    }

    private Throwable getDeepCause(Throwable e) {
        Throwable cause = e;
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return cause;
    }

    public static class ErrorResponse {
        public String title;
        public int status;
        public List<Violation> violations;

        public ErrorResponse(String title, int status, List<Violation> violations) {
            this.title = title;
            this.status = status;
            this.violations = violations;
        }
    }

    public static class Violation {
        public String field;
        public String message;

        public Violation(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }
}


