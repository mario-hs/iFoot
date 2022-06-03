package les.ifoot.config;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import les.ifoot.services._DBService;

@Configuration
@Profile("dev")
public class ConfigurationDBDev {
    @Autowired
    private _DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean handleDataBase() throws ParseException, IOException {
        if (!"create".equals(strategy)) {
            return false;
        }
        dbService.handleDataBaseTest();
        return true;
    }

}
