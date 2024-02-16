

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.PersonnelRepository;
import com.coris.facturation.models.Personnel;
import com.coris.facturation.services.IPersonnelService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class PersonnelServiceImpl implements IPersonnelService { 

        @Autowired
        private PersonnelRepository personnelRepository;
      
        // Create operation
        @Override
        @Transactional
        public Personnel create(Personnel personnel_new)
        {
            personnel_new.setHorodatage();
            return personnelRepository.save(personnel_new);
        }
      
        // Read all data
        @Override
        public List<Personnel> readAll()
        {
            return (List<Personnel>)
            personnelRepository.findAll();
        }


        // Read all data
        @Override
        public List<Personnel> findAll()
        {
            return (List<Personnel>)
            personnelRepository.findAll();
        }


        @Override
        public Personnel readOneById(String matricule)
        {
            return personnelRepository.findById(matricule).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Personnel
        update (Personnel personnel_new,
          String matricule_old)
        {
            Personnel personnel_old
                = personnelRepository.findById(matricule_old).get();
            
        
          // mettre à jour la proriété Matricule, String qui ne doit pas être null ou vide
          if (Objects.nonNull(personnel_new.getMatricule())
                && !"".equalsIgnoreCase(
                    personnel_new.getMatricule())) {
                      personnel_old.setMatricule(
                    personnel_new.getMatricule());
            }

          
            // mettre à jour la proriété Direct_id, Integer qui peut être null ou vide
            personnel_old.setDirect_id(personnel_new.getDirect_id());  
            
          // mettre à jour la proriété Pers_nom, String qui ne doit pas être null ou vide
          if (Objects.nonNull(personnel_new.getPers_nom())
                && !"".equalsIgnoreCase(
                    personnel_new.getPers_nom())) {
                      personnel_old.setPers_nom(
                    personnel_new.getPers_nom());
            }

          
          // mettre à jour la proriété Pers_prenom, String qui ne doit pas être null ou vide
          if (Objects.nonNull(personnel_new.getPers_prenom())
                && !"".equalsIgnoreCase(
                    personnel_new.getPers_prenom())) {
                      personnel_old.setPers_prenom(
                    personnel_new.getPers_prenom());
            }

          
          // mettre à jour la proriété Pers_email, String qui ne doit pas être null ou vide
          if (Objects.nonNull(personnel_new.getPers_email())
                && !"".equalsIgnoreCase(
                    personnel_new.getPers_email())) {
                      personnel_old.setPers_email(
                    personnel_new.getPers_email());
            }

          
            // mettre à jour la proriété Pers_date_integration, Date qui peut être null ou vide
            personnel_old.setPers_date_integration(personnel_new.getPers_date_integration());  
            
            // mettre à jour la proriété Supp_code, String qui peut être null ou vide
            personnel_old.setSupp_code(personnel_new.getSupp_code());  
            
            
            personnel_old.setHorodatage();
            return personnelRepository.save(personnel_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(String matricule_old)
        {
            personnelRepository.deleteById(matricule_old);
        }

    }
