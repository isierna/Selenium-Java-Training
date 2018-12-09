package ua.solomon.trainings.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.Properties;

public class ProjectUtils implements GetProperty {

    public Class<? extends Annotation> annotationType() {
        return GetProperty.class;
    }

    @Override
    public String property() {
        Properties properties = new Properties();

        Class c = GetProperty.class;


        try {
            InputStream input = new FileInputStream("src/resources/config.properties");
            properties.load(input);
            String propertyValue = properties.getProperty("browser");
            return propertyValue;


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "123";
    }
}
