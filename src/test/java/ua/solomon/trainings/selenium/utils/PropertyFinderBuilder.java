package ua.solomon.trainings.selenium.utils;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyFinderBuilder {
    Class<?> value();
}
