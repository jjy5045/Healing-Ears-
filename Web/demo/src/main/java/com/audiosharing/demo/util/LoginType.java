package com.audiosharing.demo.util;

import java.lang.annotation.Target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginType {
    public static enum UserType {
        USER, ADMIN
    }

    UserType type();
}
