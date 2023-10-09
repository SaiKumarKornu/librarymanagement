package com.library.management.LibraryManagementApplication.Exceptions;

public class NoUsersFoundException extends RuntimeException {
    public NoUsersFoundException(String msg) {
        super(msg);
    }
}