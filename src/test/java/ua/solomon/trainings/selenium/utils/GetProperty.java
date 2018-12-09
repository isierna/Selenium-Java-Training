package ua.solomon.trainings.selenium.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//this annotation can be applied only to the field and executed at runtime
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GetProperty {
    String property();
}


