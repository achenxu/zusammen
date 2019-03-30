package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.RideOffer;

public interface RideOfferRepository extends MongoRepository<RideOffer, String> {

}
