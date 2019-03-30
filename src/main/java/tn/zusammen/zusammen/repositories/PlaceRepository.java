package tn.zusammen.zusammen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.zusammen.zusammen.entities.Place;

public interface PlaceRepository extends MongoRepository<Place, String> {

}
