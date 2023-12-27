package com.gbs.apiaddress.shared.exceptions;

public class InvalidCepException extends RuntimeException{
    public InvalidCepException(String cep) {
        super(String.format("Cep: %s inválido, favor informar somente 8 caracteres númericos", cep));
    }
}
