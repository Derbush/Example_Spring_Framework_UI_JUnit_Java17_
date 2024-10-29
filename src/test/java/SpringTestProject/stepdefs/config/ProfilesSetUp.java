package SpringTestProject.stepdefs.config;

import SpringTestProject.utilities.annotations.LazyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@LazyComponent
public class ProfilesSetUp {

    @Autowired
    private Environment environment;

    public String getActiveProfile() {
        return environment.getActiveProfiles()[environment.getActiveProfiles().length - 1];
    }

}