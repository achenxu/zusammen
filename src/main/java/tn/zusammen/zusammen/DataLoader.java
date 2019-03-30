package tn.zusammen.zusammen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.geo.Point;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tn.zusammen.zusammen.entities.Place;
import tn.zusammen.zusammen.entities.RideOffer;
import tn.zusammen.zusammen.entities.User;
import tn.zusammen.zusammen.enums.RideOfferState;
import tn.zusammen.zusammen.repositories.PlaceRepository;
import tn.zusammen.zusammen.repositories.RideOfferRepository;
import tn.zusammen.zusammen.repositories.UserRepository;

import java.util.Date;
import java.util.LinkedHashSet;

@Component
@Profile("develop")
public final class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RideOfferRepository rideOfferRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        userRepository.deleteAll();
        placeRepository.deleteAll();

        User admin = new User("admin", "admin@admin", passwordEncoder.encode("admin"));
        userRepository.save(admin);

        /**
         * Create new ride offer
         */
        Place pickUp = new Place("Tunis 1", new Point(36.83113422277796, 10.147884084661849));
        Place dropOff = new Place("Tunis 2", new Point(36.83385638712979, 10.147990952798748));
        placeRepository.save(pickUp);
        placeRepository.save(dropOff);

        RideOffer rideOffer = new RideOffer(admin, new Date());
        LinkedHashSet<Place> path = new LinkedHashSet<>();
        path.add(pickUp);
        path.add(dropOff);
        rideOffer.setPath(path);
        rideOffer.setState(RideOfferState.ACTIVE);
        rideOfferRepository.save(rideOffer);
    }

}
