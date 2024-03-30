package springboot.orderstrackingsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;;
@Configuration
public class SwaggerAPi {
    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI().info(new Info().title("Spring Doc").version("2.0.2").description("Spring doc"));
    }
}
