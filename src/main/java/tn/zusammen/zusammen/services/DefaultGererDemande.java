package tn.zusammen.zusammen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.zusammen.zusammen.entities.Demande;
import tn.zusammen.zusammen.entities.User;
import tn.zusammen.zusammen.entities.Voyage;
import tn.zusammen.zusammen.repositories.DemandeRepository;

import java.util.Iterator;
import java.util.Optional;

@Service
public class DefaultGererDemande implements GererDemande {

    @Autowired
    private DemandeRepository demandeRepository;

    @Override
    public Demande ajouterVoyageur(Demande demande, Voyage voyage, User voyageur) {
        String idVoyageur = voyageur.getCin();

        Optional<Demande> demandeOptional = demandeRepository.findById(demande.getId());
        if (demandeOptional.isPresent()) {
            if (voyage.getNbrePlaceRest() > 0) {
                boolean x = true;
                Iterator<User> it = demande.getUsers().iterator();
                while (it.hasNext()) {
                    User voy = it.next();
                    if (voy.getCin() == idVoyageur) {
                        x = false;
                    }
                    x = true;
                }

                if (x == true) {
                    voyage.setNbrePlaceRest(voyage.getNbrePlaceRest() - 1);
                    demande.setEtat("accepted");
                    demande.getVoyages().add(voyage);
                    demande.getUsers().add(voyageur);

                    return demandeRepository.save(demande);
                }
            }
        }

        return null;
    }

    @Override
    public void refuserVoyageur(Demande demande, Voyage voyage, String idVoyageur) {
        String demandeId;
        demandeId = demande.getId();

        Optional<Demande> demandeOptional = demandeRepository.findById(demande.getId());
        if (demandeOptional.isPresent()) {
            Iterator<User> it = demande.getUsers().iterator();
            while (it.hasNext()) {
                User voy = it.next();
                if (voy.getCin() == idVoyageur) {
                    it.remove();
                    voyage.setNbrePlaceRest(voyage.getNbrePlaceRest() + 1);
                    demande.setEtat("refused");
                    demandeRepository.deleteById(demandeId);
                }
            }
        }
    }

}
