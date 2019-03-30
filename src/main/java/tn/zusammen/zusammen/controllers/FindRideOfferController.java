package tn.zusammen.zusammen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tn.zusammen.zusammen.dtos.FindRideOfferFormDTO;
import tn.zusammen.zusammen.services.FindRideOfferService;

@Controller
public final class FindRideOfferController extends MetaController {

    @Autowired
    private FindRideOfferService findRideOfferService;

    @GetMapping("/find-ride-offer")
    public String findRideOfferForm(Model model) {
        initModel(model, "Find a ride");
        model.addAttribute(new FindRideOfferFormDTO());

        return "find-ride-offer";
    }

    @PostMapping("/find-ride-offer")
    public String findRideOfferSubmit(@ModelAttribute FindRideOfferFormDTO findRideOfferFormDTO, Model model) {
        model.addAttribute(findRideOfferService.findRideOffer(findRideOfferFormDTO));

        return "find-ride-offer-result";
    }

}
