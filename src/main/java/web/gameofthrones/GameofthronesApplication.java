package web.gameofthrones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GameofthronesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameofthronesApplication.class, args);
    }

}
