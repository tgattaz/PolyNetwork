package com.polytech.polynet.exceptions;

public class NameTakenException extends Exception {

    public NameTakenException() {
        super("Nom d'utilisateur déjà utilisé.");
    }
}
