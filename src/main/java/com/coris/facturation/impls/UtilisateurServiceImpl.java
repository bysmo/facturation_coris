
package com.coris.facturation.impls;

import com.coris.facturation.repositories.RoleRepository;

// Importing required classes

import com.coris.facturation.repositories.UtilisateurRepository;
import com.coris.facturation.models.Role;
import com.coris.facturation.models.Utilisateur;
import com.coris.facturation.services.IUtilisateurService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

  @Autowired
  private UtilisateurRepository utilisateurRepository;

  private RoleRepository roleRepository;
  private PasswordEncoder passwordEncoder;

  public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository,
      RoleRepository roleRepository,
      PasswordEncoder passwordEncoder) {
    this.utilisateurRepository = utilisateurRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  // Create operation
  @Override
  @Transactional
  public void create(Utilisateur utilisateur_new) {
    utilisateur_new.setHorodatage();

    utilisateur_new.setUser_password(passwordEncoder.encode(utilisateur_new.getUser_password()));

    Role role = roleRepository.findByRole_name("ROLE_ADMIN");
    if (role == null) {
      role = checkRoleExist();
    }
    utilisateur_new.setRoles(Arrays.asList(role));

    utilisateurRepository.save(utilisateur_new);
  }

  // Read all data
  @Override
  public List<Utilisateur> readAll() {
    return (List<Utilisateur>) utilisateurRepository.findAll();
  }

  // Read all data
  @Override
  public List<Utilisateur> findAll() {
    return (List<Utilisateur>) utilisateurRepository.findAll();
  }

  @Override
  public Utilisateur readOneById(Long user_id) {
    return utilisateurRepository.findById(user_id).orElse(null);
  }

  // Update operation
  @Override
  @Transactional
  public Utilisateur update(Utilisateur utilisateur_new,
      Long user_id_old) {
    Utilisateur utilisateur_old = utilisateurRepository.findById(user_id_old).get();

    // mettre à jour la proriété Matricule, String qui ne doit pas être null ou vide
    if (Objects.nonNull(utilisateur_new.getMatricule())
        && !"".equalsIgnoreCase(
            utilisateur_new.getMatricule())) {
      utilisateur_old.setMatricule(
          utilisateur_new.getMatricule());
    }

    // mettre à jour la proriété User_email, String qui peut être null ou vide
    utilisateur_old.setUser_email(utilisateur_new.getUser_email());

    utilisateur_old.setHorodatage();
    return utilisateurRepository.save(utilisateur_old);
  }

  // Delete operation
  @Override
  @Transactional
  public void delete(Long user_id_old) {
    utilisateurRepository.deleteById(user_id_old);
  }

  @Override
  public Utilisateur findByEmail(String email) {
    return utilisateurRepository.findByUser_email(email);
  }

  @Override
  public Utilisateur findByMatricule(String matricule) {
    return utilisateurRepository.findByMatricule(matricule);
  }

  private Role checkRoleExist() {
    Role role = new Role();
    role.setRole_name("ROLE_ADMIN");
    return roleRepository.save(role);
  }

}
