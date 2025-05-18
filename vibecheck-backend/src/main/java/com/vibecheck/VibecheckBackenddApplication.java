package com.vibecheck;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vibecheck.model.Question;
import com.vibecheck.repository.QuestionRepository;

@SpringBootApplication
public class VibecheckBackenddApplication {

	public static void main(String[] args) {
		SpringApplication.run(VibecheckBackenddApplication.class, args);

	}


		   @Bean
    CommandLineRunner run(QuestionRepository repo) {
        return args -> {
            repo.save(new Question(null, "How do you debug code?", List.of("Console.log", "Rubber duck", "GPT", "Walk away")));
            repo.save(new Question(null, "What's your dev fuel?", List.of("Coffee", "Tea", "Energy Drink", "Water")));
            repo.save(new Question(null, "Best time to code?", List.of("Night", "Morning", "Afternoon", "Whenever")));
            repo.save(new Question(null, "What describes you?", List.of("Creative", "Logical", "Calm", "Fast")));
            repo.save(new Question(null, "Favorite stack?", List.of("MERN", "Spring Boot", "Django", "Flutter")));
        };
	
}

}
