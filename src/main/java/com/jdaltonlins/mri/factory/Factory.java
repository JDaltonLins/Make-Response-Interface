package com.jdaltonlins.mri.factory;

import com.jdaltonlins.mri.Request;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class Factory {

    public static <E> E make(Class<E> clazz, String url) {
        for (Method method : clazz.getMethods()) {
            if(!Modifier.isAbstract(method.getModifiers())) continue;
            Request request = method.getAnnotation(Request.class);
            if(request == null) continue;
            Proxy.
        }
    }

    public static <E> E make(Class<E> clazz) {

    }

}
