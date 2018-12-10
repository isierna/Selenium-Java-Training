package ua.solomon.trainings.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectUtils {
    public static String getProperty(String propertieName) {
        Properties properties = new Properties();

        try {
            InputStream input = new FileInputStream("src/resources/config.properties");
            properties.load(input);
            String propertyValue = properties.getProperty(propertieName);
            return propertyValue;


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
