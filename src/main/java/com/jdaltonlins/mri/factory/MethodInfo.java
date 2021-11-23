package com.jdaltonlins.mri.factory;

import com.jdaltonlins.mri.factory.util.FastPlaceholder;
import com.jdaltonlins.mri.request.Request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MethodInfo {

    private String route;
    private String method;
    private List<String> params;
    private String bodyFormat;
    private String[] headers;

    private boolean future;
    private Class resultType;

    public MethodInfo(String route, String method, List<String> params, String bodyFormat, String[] headers, boolean future, Class resultType) {
        this.route = route;
        this.method = method;
        this.params = params;
        this.headers = headers;
        this.bodyFormat = bodyFormat;
        this.future = future;
        this.resultType = resultType;
    }

    public Request makeRequest(List<Object> args) {
        if(args.size() != params.size()) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        Map<String, String> values = new HashMap<>();
        for (int i = 0; i < params.size(); i++) {
            Object arg = args.get(i);
            String.valueOf("  ");
            values.put(params.get(i), args.get(i));
        }
        Arrays.stream(headers).map(e-> FastPlaceholder.__replace(e, values::get, '{', '}'));

    }

    public String[] getHeaders() {
        return headers;
    }

    public String getRoute() {
        return route;
    }

    public String getMethod() {
        return method;
    }

    public List<String> getParams() {
        return params;
    }

    public String getBodyFormat() {
        return bodyFormat;
    }

    public boolean isFuture() {
        return future;
    }

    public Class getResultType() {
        return resultType;
    }
}
