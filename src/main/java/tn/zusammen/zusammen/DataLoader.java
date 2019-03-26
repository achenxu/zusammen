package tn.zusammen.zusammen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tn.zusammen.zusammen.entities.User;
import tn.zusammen.zusammen.repositories.UserRepository;

@Component
@Profile("develop")
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        userRepository.deleteAll();
        userRepository.save(
                new User("admin", "admin@admin", passwordEncoder.encode("admin"))
        );
    }

}
