package equipment;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    @EnableWebMvc
    public class WebMvcConfigure extends WebMvcConfigurerAdapter {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry
                    .addMapping("/**")
                    .allowedOrigins("*");
        }
    }
}
