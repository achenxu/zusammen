package tn.zusammen.zusammen.services;

import org.springframework.stereotype.Service;
import tn.zusammen.zusammen.dtos.FindRideOfferFormDTO;
import tn.zusammen.zusammen.dtos.FindRideOfferResultDTO;

@Service
public final class FindRideOfferService {

    public FindRideOfferResultDTO findRideOffer(FindRideOfferFormDTO findRideOfferFormDTO) {
        return new FindRideOfferResultDTO();
    }

}
