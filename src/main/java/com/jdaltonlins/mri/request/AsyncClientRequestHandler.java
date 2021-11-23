package com.jdaltonlins.mri.request;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.RequestBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class AsyncClientRequestHandler implements RequestHandler {

    private AsyncHttpClient client;

    public AsyncClientRequestHandler(AsyncHttpClient client) {
        this.client = client;
    }

    @Override
    public Future<Response> make(Request base) {
        RequestBuilder builder = new RequestBuilder(base.getMethod()).setUrl(base.getUrl().toString());

        for (Map.Entry<String, String> entry : base.getHeaders().entrySet()) {
            builder.setHeader(entry.getKey(), entry.getValue());
        }

        if (base.getBody() != null)
            builder.setBody(base.getBody());

        return client.executeRequest(builder).toCompletableFuture()
                .thenApply(e -> new Response(e.getStatusCode(), e.getHeaders()
                        .entries()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a + ";" + b)), e.getResponseBody().getBytes(StandardCharsets.UTF_8), null));
    }
}
