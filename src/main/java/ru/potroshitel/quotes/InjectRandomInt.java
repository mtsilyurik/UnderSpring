package ru.potroshitel.quotes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
