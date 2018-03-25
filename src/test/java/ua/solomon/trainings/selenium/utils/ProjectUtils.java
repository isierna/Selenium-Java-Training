package ua.solomon.trainings.selenium.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ProjectUtils {
    public String getSystemSeleniumVersion() throws IOException {

        FileReader reader = new FileReader("./src/resources/my.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return properties.getProperty("selenium-java.version");
    }
}
