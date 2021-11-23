package com.jdaltonlins.mri.request;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class PollJavaRequestHandler extends JavaRequestHandler {

    private ExecutorService service;

    public PollJavaRequestHandler(ExecutorService service) {
        this.service = service;
    }

    @Override
    public Future<Response> make(Request base) {
        return service.submit(super.makeRequest(base));
    }
}
