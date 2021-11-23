package com.jdaltonlins.mri.factory.proxied;

import com.jdaltonlins.mri.factory.MethodInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProxiedFactory implements InvocationHandler {

    private Map<Integer, MethodInfo> methodInfoMap = new HashMap<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInfo mi = methodInfoMap.get(method.hashCode());

        return null;
    }
}
