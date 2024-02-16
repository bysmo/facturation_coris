
package com.coris.facturation.services;

import java.util.List;
import com.coris.facturation.models.Affectation;
import com.coris.facturation.models.AffectationPK;

import org.springframework.stereotype.Service;

@Service
public interface IAffectationService {

    // Save operation
    Affectation create(Affectation affectation);

    // Read all data
    List<Affectation> readAll();

    // Read all data
    List<Affectation> findAll();

    // Read all data
    // List<Affectation> findByAttribute1(String params);

    // Read operation
    Affectation readOneById(AffectationPK affectationId);

    // Update operation
    Affectation update(Affectation affectation, AffectationPK affectationId);

    // Delete operation
    void delete(AffectationPK affectationId);

}
