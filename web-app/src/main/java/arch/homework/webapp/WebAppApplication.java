package arch.homework.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

}
