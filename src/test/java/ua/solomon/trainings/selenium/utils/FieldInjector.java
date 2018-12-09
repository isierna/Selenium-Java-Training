package ua.solomon.trainings.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

// this class and its methods needed to replace annotated variable with the value frpm config.properties
public class FieldInjector implements GetProperty {
    public static void injectFieldValue(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(GetProperty.class)) {
                GetProperty annotationProperty = field.getAnnotation(GetProperty.class);
                field.setAccessible(true);
                String annotationPropertyValue = annotationProperty.property();
                String annotationPropertyName = field.getName();

                Properties projectProperties = new Properties();

                try {
                    InputStream inputStream = new FileInputStream("src/resources/config.properties");
                    projectProperties.load(inputStream);

                    String newValue = projectProperties.getProperty(annotationPropertyValue);
                    field.setAccessible(true);
                    field.set(object, newValue);


                } catch (IOException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String property() {
        String browser = "www";
        return browser;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
