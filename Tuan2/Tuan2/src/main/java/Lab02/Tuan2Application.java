package Lab02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Lab02"}) // Quét các package trong Lab02 để tìm các bean
public class Tuan2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tuan2Application.class, args);
	}

}
