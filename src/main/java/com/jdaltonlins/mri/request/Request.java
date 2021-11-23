package com.jdaltonlins.mri.request;

import java.net.URL;
import java.util.Map;

public class Request {

    private URL url;
    private String method;
    private Map<String, String> headers;
    private byte[] body;

    public Request(URL url, String method, Map<String, String> headers, byte[] body) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = body;
    }

    public URL getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public byte[] getBody() {
        return body;
    }
}
