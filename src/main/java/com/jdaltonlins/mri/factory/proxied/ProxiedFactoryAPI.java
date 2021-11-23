package com.jdaltonlins.mri.factory.proxied;

import com.jdaltonlins.mri.BaseURL;
import com.jdaltonlins.mri.Param;
import com.jdaltonlins.mri.ParamBody;
import com.jdaltonlins.mri.factory.FactoryAPI;
import com.jdaltonlins.mri.factory.MethodInfo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ProxiedFactoryAPI implements FactoryAPI {

    @Override
    public <E> E make(Class<E> clazz, String url) {
        if(clazz.isAnnotationPresent(BaseURL.class))
            url = clazz.getAnnotation(BaseURL.class).value();



        for (Method method : clazz.getMethods()) {
            int modifiers = method.getModifiers();
            Param param = method.getAnnotation(Param.class);
            ParamBody paramBody = method.getAnnotation(ParamBody.class);
            if(!Modifier.isAbstract(modifiers) || Modifier.isStatic(modifiers) || param == null || paramBody == null)
                if(url != null && method.isAnnotationPresent(BaseURL.class))
                    url = method.getAnnotation(BaseURL.class).value();
                continue;
            }
            MethodInfo methodInfo = new MethodInfo(method, url);

        }
        return null;
    }

    @Override
    public <E> E make(Class<E> clazz) {
        return make(clazz, null);
    }
}
