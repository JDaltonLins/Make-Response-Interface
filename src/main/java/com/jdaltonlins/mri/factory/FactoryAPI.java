package com.jdaltonlins.mri.factory;

public interface FactoryAPI {

    <E> E make(Class<E> clazz, String url);

    <E> E make(Class<E> clazz);

}
