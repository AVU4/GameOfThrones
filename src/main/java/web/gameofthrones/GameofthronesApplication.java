package web.gameofthrones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import web.gameofthrones.Repositories.Custom.CustomRepositoryImpl;

@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
@SpringBootApplication
public class GameofthronesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameofthronesApplication.class, args);
    }

}
