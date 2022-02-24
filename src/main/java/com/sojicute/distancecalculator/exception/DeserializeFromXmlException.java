package com.sojicute.distancecalculator.exception;

public class DeserializeFromXmlException extends RuntimeException {

    public DeserializeFromXmlException(String msg) {
        super(msg);
    }

    public DeserializeFromXmlException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
