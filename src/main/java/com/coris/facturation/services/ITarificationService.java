
package com.coris.facturation.services;

import java.util.List;
import com.coris.facturation.models.Tarification;
import com.coris.facturation.models.TarificationPK;

import org.springframework.stereotype.Service;

@Service
public interface ITarificationService {

    // Save operation
    Tarification create(Tarification tarification);

    // Read all data
    List<Tarification> readAll();

    // Read all data
    List<Tarification> findAll();

    // Read all data
    // List<Tarification> findByAttribute1(String params);

    // Read operation
    Tarification readOneById(TarificationPK tarificationId);

    // Update operation
    Tarification update(Tarification tarification, TarificationPK tarificationId);

    // Delete operation
    void delete(TarificationPK tarificationId);

}
