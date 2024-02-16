
package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.AffectationRepository;
import com.coris.facturation.models.Affectation;
import com.coris.facturation.models.AffectationPK;
import com.coris.facturation.services.IAffectationService;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AffectationServiceImpl implements IAffectationService {

    @Autowired
    private AffectationRepository affectationRepository;

    // Create operation
    @Override
    @Transactional
    public Affectation create(Affectation affectation_new) {
        affectation_new.setHorodatage();
        return affectationRepository.save(affectation_new);
    }

    // Read all data
    @Override
    public List<Affectation> readAll() {
        return (List<Affectation>) affectationRepository.findAll();
    }

    // Read all data
    @Override
    public List<Affectation> findAll() {
        return (List<Affectation>) affectationRepository.findAll();
    }

    @Override
    public Affectation readOneById(AffectationPK Filiale_id) {
        return affectationRepository.findById(Filiale_id).orElse(null);
    }

    // Update operation
    @Override
    @Transactional
    public Affectation update(Affectation affectation_new,
            AffectationPK Filiale_id_old) {
        Affectation affectation_old = affectationRepository.findById(Filiale_id_old).get();

        // mettre à jour la proriété Real_id, Long qui ne doit pas être null ou vide
        if (Objects.nonNull(affectation_new.getAffectationPK().getReal_id())) {
            affectation_old.getAffectationPK().setReal_id(
                    affectation_new.getAffectationPK().getReal_id());
        }

        // mettre à jour la proriété Filiale_id, Integer qui ne doit pas être null ou
        // vide
        if (Objects.nonNull(affectation_new.getAffectationPK().getFiliale_id())) {
            affectation_old.getAffectationPK().setFiliale_id(
                    affectation_new.getAffectationPK().getFiliale_id());
        }

        // mettre à jour la proriété Cle_repartition, Integer qui peut être null ou vide
        affectation_old.setCle_repartition(affectation_new.getCle_repartition());

        // mettre à jour la proriété PJ_filiale, String qui peut être null ou vide
        affectation_old.setPJ_filiale(affectation_new.getPJ_filiale());

        affectation_old.setHorodatage();
        return affectationRepository.save(affectation_old);
    }

    // Delete operation
    @Override
    @Transactional
    public void delete(AffectationPK Filiale_id_old) {
        affectationRepository.deleteById(Filiale_id_old);
    }

}
