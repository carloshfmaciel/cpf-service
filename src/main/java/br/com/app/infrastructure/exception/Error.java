package br.com.app.infrastructure.exception;

public enum Error {

	CPF_NOT_FOUND("CPF_NOT_FOUND", "Cpf not found!");

    private final String code;
    private final String message;

    private Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
