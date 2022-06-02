package les.ifoot.config;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import les.ifoot.services._DBService;

@Configuration
@Profile("test")
public class ConfigurationDBTest {
    @Autowired
    private _DBService dbService;

    @Bean
    public boolean handleDataBase() throws ParseException, IOException {
        dbService.handleDataBaseTest();
        return true;
    }
}
