package tn.zusammen.zusammen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.zusammen.zusammen.repositories.UserRepository;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        tn.zusammen.zusammen.entities.User user = userRepository.findByEmail(email);

        if (user != null) {
            return org.springframework.security.core.userdetails.User
                    .withDefaultPasswordEncoder()
                    .username(user.getEmail())
                    .password(user.getMdp())
                    .roles(user.getRole().toString())
                    .build();
        } else {
            throw new UsernameNotFoundException(email + "was not found.");
        }
    }

}
