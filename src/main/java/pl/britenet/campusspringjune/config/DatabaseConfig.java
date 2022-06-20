package pl.britenet.campusspringjune.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.britenet.consoleapp.service.DatabaseService;

@Configuration
public class DatabaseConfig {

    @Bean
    public DatabaseService getDatabaseService() {
        return new DatabaseService();
    }

}
