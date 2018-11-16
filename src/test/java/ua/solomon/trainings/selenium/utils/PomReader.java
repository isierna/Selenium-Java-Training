package ua.solomon.trainings.selenium.utils;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PomReader {
    private Properties getPomData() {
        Model model = null;
        FileReader fileReader;
        MavenXpp3Reader mavenReader = new MavenXpp3Reader();

        try {
            fileReader = new FileReader("pom.xml");
            model = mavenReader.read(fileReader);
            model.setPomFile(new File("pom.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        MavenProject mavenProject = new MavenProject(model);
        return mavenProject.getProperties();
    }


    public String getSeleniumVersion() {
        Properties properties = getPomData();
        return properties.getProperty("selenium.version");
    }
}
