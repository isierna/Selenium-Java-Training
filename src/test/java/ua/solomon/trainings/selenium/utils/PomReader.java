package ua.solomon.trainings.selenium.utils;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PomReader {
    public String getSeleniumVersion() {
        Properties properties = getPomData();
        return properties.getProperty("selenium-java.version");
    }

    private Properties getPomData() {
        MavenXpp3Reader reader = new MavenXpp3Reader();

        try {
            Model model = reader.read(new FileReader("pom.xml"));
            MavenProject project = new MavenProject(model);
            return project.getProperties();
        } catch (XmlPullParserException | IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
