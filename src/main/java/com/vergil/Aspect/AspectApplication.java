package com.vergil.Aspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AspectApplication {
	
	/**
	 * Main method, used to run the application.
	 *
	 * @param args the command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AspectApplication.class, args);
		printaAlgoLegal();
	}

	private static void printaAlgoLegal() {
        System.out.println("\n----------------------------------------------------------\n\t" +
            "Application '{}' is running! Access URLs:\n\t" +
            "Local: \t\thttp://localhost:8080\n\t" );


	}

}
