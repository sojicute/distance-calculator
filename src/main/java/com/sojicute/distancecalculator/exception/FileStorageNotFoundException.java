package com.sojicute.distancecalculator.exception;

public class FileStorageNotFoundException extends FileStorageException {

    public FileStorageNotFoundException(String msg) {
        super(msg);
    }

    public FileStorageNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
