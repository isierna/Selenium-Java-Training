package ua.solomon.trainings.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Properties;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@PropertyFinderBuilder(FindProperie.FindPropertyBL.class)



public @interface FindProperie {
    String prop() default "";

    public static class FindPropertyBL {
        public WebDriver driver;
        public FindPropertyBL(Object annotation) {
            FindProperie properie = (FindProperie) annotation;
            Properties pr = new Properties();
            String propertyValue;

            try {
                InputStream input = new FileInputStream("src/resources/config.properties");
                pr.load(input);
                propertyValue = pr.getProperty(properie.toString());

                switch (propertyValue) {
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "safari":
                        driver = new SafariDriver();
                        break;
                    case "IE":
                        driver = new InternetExplorerDriver();
                        break;
                    default:
                        throw new NullPointerException("Please, specify a browser");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}




