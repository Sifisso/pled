package mz.pled.mgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MgrApplication.class, args);
		System.out.println("Compilado com sucesso...");
	}

}
