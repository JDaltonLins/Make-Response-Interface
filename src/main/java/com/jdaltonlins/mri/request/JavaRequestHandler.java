package com.jdaltonlins.mri.request;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class JavaRequestHandler implements RequestHandler {

    // Prepara o request para poder ser enviado depois.
    public Callable<Response> makeRequest(Request base) {
        return () -> {
            try {
                HttpURLConnection connection = (HttpURLConnection) base.getUrl().openConnection();
                connection.setRequestMethod(base.getMethod());
                for (Map.Entry<String, String> entry : base.getHeaders().entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                boolean hasBody = base.getBody() != null;
                connection.setDoOutput(hasBody);
                if (hasBody)
                    try (OutputStream out = connection.getOutputStream()) {
                        out.write(base.getBody());
                    }


                connection.connect();

                try (InputStream in = connection.getInputStream()) {
                    ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
                    int length;
                    byte[] buf = new byte[1024 * 4];
                    while ((length = in.read(buf)) > 0) {
                        bOutput.write(buf, 0, length);
                    }
                    return new Response(connection.getResponseCode(), new HashMap<>(), bOutput.toByteArray());
                }
            } catch (Throwable ex) {
                return new Response(ex);
            }
        };
    }

    @Override
    public Future<Response> make(Request base) {
        return new FutureTask<>(makeRequest(base));
    }
}
