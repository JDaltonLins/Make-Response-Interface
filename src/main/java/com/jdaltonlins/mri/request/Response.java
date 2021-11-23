package com.jdaltonlins.mri.request;

import java.util.Map;

public class Response {

    private int status;
    private Map<String, String> headers;
    private byte[] result;

    private Throwable exception;

    public Response(int status, Map<String, String> headers, byte[] result) {
        this.status = status;
        this.headers = headers;
        this.result = result;
    }

    public Response(Throwable exception) {
        this.exception = exception;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public byte[] getResult() {
        return result;
    }

    public Throwable getException() {
        return exception;
    }
}
