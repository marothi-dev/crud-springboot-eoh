package za.co.eoh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "za.co.eoh" })
public class InvoicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(InvoicesApplication.class, args);
	}
}
