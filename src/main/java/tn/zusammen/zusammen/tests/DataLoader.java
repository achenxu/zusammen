package tn.zusammen.zusammen.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tn.zusammen.zusammen.entities.Role;
import tn.zusammen.zusammen.entities.User;
import tn.zusammen.zusammen.repositories.RoleRepository;
import tn.zusammen.zusammen.repositories.UserRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        userRepository.save(new User("admin@admin", "admin", Role.ADMIN));
    }

}
