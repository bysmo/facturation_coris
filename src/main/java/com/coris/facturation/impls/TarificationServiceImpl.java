
package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.TarificationRepository;
import com.coris.facturation.models.Tarification;
import com.coris.facturation.models.TarificationPK;
import com.coris.facturation.services.ITarificationService;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TarificationServiceImpl implements ITarificationService {

  @Autowired
  private TarificationRepository tarificationRepository;

  // Create operation
  @Override
  @Transactional
  public Tarification create(Tarification tarification_new) {
    tarification_new.setHorodatage();
    return tarificationRepository.save(tarification_new);
  }

  // Read all data
  @Override
  public List<Tarification> readAll() {
    return (List<Tarification>) tarificationRepository.findAll();
  }

  // Read all data
  @Override
  public List<Tarification> findAll() {
    return (List<Tarification>) tarificationRepository.findAll();
  }

  @Override
  public Tarification readOneById(TarificationPK tarif_code) {
    return tarificationRepository.findById(tarif_code).orElse(null);
  }

  // Update operation
  @Override
  @Transactional
  public Tarification update(Tarification tarification_new,
      TarificationPK tarif_code_old) {
    Tarification tarification_old = tarificationRepository.findById(tarif_code_old).get();

    // mettre à jour la proriété Activ_id, Integer qui ne doit pas être null ou vide
    if (Objects.nonNull(tarification_new.getTarificationPK().getActiv_id())) {
      tarification_old.getTarificationPK().setActiv_id(
          tarification_new.getTarificationPK().getActiv_id());
    }

    // mettre à jour la proriété Supp_code, String qui ne doit pas être null ou vide
    if (Objects.nonNull(tarification_new.getTarificationPK().getSupp_code())
        && !"".equalsIgnoreCase(
            tarification_new.getTarificationPK().getSupp_code())) {
      tarification_old.getTarificationPK().setSupp_code(
          tarification_new.getTarificationPK().getSupp_code());
    }

    // mettre à jour la proriété Tarif_code, String qui ne doit pas être null ou
    // vide
    if (Objects.nonNull(tarification_new.getTarificationPK().getTarif_code())
        && !"".equalsIgnoreCase(
            tarification_new.getTarificationPK().getTarif_code())) {
      tarification_old.getTarificationPK().setTarif_code(
          tarification_new.getTarificationPK().getTarif_code());
    }

    // mettre à jour la proriété MONTANT_TARIF, Double qui peut être null ou vide
    tarification_old.setMONTANT_TARIF(tarification_new.getMONTANT_TARIF());

    tarification_old.setHorodatage();
    return tarificationRepository.save(tarification_old);
  }

  // Delete operation
  @Override
  @Transactional
  public void delete(TarificationPK tarif_code_old) {
    tarificationRepository.deleteById(tarif_code_old);
  }

}
