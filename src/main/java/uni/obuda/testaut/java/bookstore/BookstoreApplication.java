package uni.obuda.testaut.java.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import uni.obuda.testaut.java.bookstore.config.AppConfig;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@Import(AppConfig.class)
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
