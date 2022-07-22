package waa.lab5.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapping {

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
