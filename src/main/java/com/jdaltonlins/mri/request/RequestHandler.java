package com.jdaltonlins.mri.request;

import java.util.concurrent.Future;

public interface RequestHandler {

     Future<Response> make(Request base);

}
