package com.jdaltonlins.mri;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    Usado para indicar o cabeçario das requisições.
    Exemplo:
    ```
        @Headers("Authorization: Bearer ...")
    ```
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Headers {

    String[] value();

}
