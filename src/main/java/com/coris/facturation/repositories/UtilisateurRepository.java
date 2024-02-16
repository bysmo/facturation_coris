
package com.coris.facturation.repositories;

import com.coris.facturation.models.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByMatricule(String matricule);

    Utilisateur findByUser_email(String email);
}
