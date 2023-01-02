
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



//@ComponentScan(basePackages = {"com.example.controller","com.example.service"})
//@EntityScan("com.example.model")
//@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.prasad.controller",  // MVC @Configuration
        "com.prasad.service",
        
})
@EntityScan("com.prasad.model")
@EnableJpaRepositories("com.prasad.repository")
public class SpringBootThymeLeafCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeLeafCrudApplication.class, args);
	}

}
