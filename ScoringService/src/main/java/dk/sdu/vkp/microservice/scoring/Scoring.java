package dk.sdu.vkp.microservice.scoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Scoring {
    private int score = 0;

    public static void main(String[] args) {
        SpringApplication.run(Scoring.class, args);
    }

    @GetMapping("/retrieve")
    public int getScore() {
        return score;
    }

    @GetMapping("/increase")
    public void incrementScore(@RequestParam(value = "score") int score) {
        try {
            this.score += score;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
