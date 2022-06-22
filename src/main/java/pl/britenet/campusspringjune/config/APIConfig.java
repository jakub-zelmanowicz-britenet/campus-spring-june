package pl.britenet.campusspringjune.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.britenet.consoleapp.service.DatabaseService;
import pl.britenet.consoleapp.service.ProductService;
import pl.britenet.consoleapp.service.UserService;

@Configuration
public class APIConfig {

    private final DatabaseService databaseService;

    @Autowired
    public APIConfig(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Bean
    public ProductService getProductService() {
        return new ProductService(this.databaseService);
    }

    @Bean
    public UserService getUserService() {
        return new UserService(this.databaseService);
    }

}
