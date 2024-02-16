
package com.coris.facturation.services;

import java.util.List;
import com.coris.facturation.models.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface IUtilisateurService {

    // Save operation
    void create(Utilisateur utilisateur);

    // Read all data
    List<Utilisateur> readAll();

    // Read all data
    List<Utilisateur> findAll();

    Utilisateur findByEmail(String email);

    Utilisateur findByMatricule(String matricule);

    // Read all data
    // List<Utilisateur> findByAttribute1(String params);

    // Read operation
    Utilisateur readOneById(Long utilisateurId);

    // Update operation
    Utilisateur update(Utilisateur utilisateur, Long utilisateurId);

    // Delete operation
    void delete(Long utilisateurId);

}
