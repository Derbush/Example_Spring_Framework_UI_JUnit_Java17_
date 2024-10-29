package SpringTestProject.utilities;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Log4j2
@Component
public class ConfigurationReader {

    @Value("${env}")
    private String env;

    private Properties properties;

    public Properties initializeProperties() {

        properties = new Properties();

        try {
            FileInputStream file = new FileInputStream("application-"+this.env+".properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("File not found with the given path");
            e.printStackTrace();
        }

        return properties;

    }


    public void getProperties(){
        this.initializeProperties();
    }
}