package dev.nastiar.portal.configs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.CrossOrigin;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@CrossOrigin
public @interface CrossOriginList {

    public String[] crossOrigins() default {

            "http://localhost:3030",
    };
}