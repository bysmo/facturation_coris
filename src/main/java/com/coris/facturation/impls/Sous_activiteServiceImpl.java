

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.Sous_activiteRepository;
import com.coris.facturation.models.Sous_activite;
import com.coris.facturation.services.ISous_activiteService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class Sous_activiteServiceImpl implements ISous_activiteService { 

        @Autowired
        private Sous_activiteRepository sous_activiteRepository;
      
        // Create operation
        @Override
        @Transactional
        public Sous_activite create(Sous_activite sous_activite_new)
        {
            sous_activite_new.setHorodatage();
            return sous_activiteRepository.save(sous_activite_new);
        }
      
        // Read all data
        @Override
        public List<Sous_activite> readAll()
        {
            return (List<Sous_activite>)
            sous_activiteRepository.findAll();
        }


        // Read all data
        @Override
        public List<Sous_activite> findAll()
        {
            return (List<Sous_activite>)
            sous_activiteRepository.findAll();
        }


        @Override
        public Sous_activite readOneById(Integer ssact_id)
        {
            return sous_activiteRepository.findById(ssact_id).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Sous_activite
        update (Sous_activite sous_activite_new,
          Integer ssact_id_old)
        {
            Sous_activite sous_activite_old
                = sous_activiteRepository.findById(ssact_id_old).get();
            
        
          
            // mettre à jour la proriété Ssact_id, Integer qui ne doit pas être null ou vide
          if (Objects.nonNull(sous_activite_new.getSsact_id())) {
                      sous_activite_old.setSsact_id(
                    sous_activite_new.getSsact_id());
            }

          
          // mettre à jour la proriété Ssact_code, String qui ne doit pas être null ou vide
          if (Objects.nonNull(sous_activite_new.getSsact_code())
                && !"".equalsIgnoreCase(
                    sous_activite_new.getSsact_code())) {
                      sous_activite_old.setSsact_code(
                    sous_activite_new.getSsact_code());
            }

          
            // mettre à jour la proriété Ssact_libelle, String qui peut être null ou vide
            sous_activite_old.setSsact_libelle(sous_activite_new.getSsact_libelle());  
            
            // mettre à jour la proriété Ssact_description, String qui peut être null ou vide
            sous_activite_old.setSsact_description(sous_activite_new.getSsact_description());  
            
            // mettre à jour la proriété Activ_id, Integer qui peut être null ou vide
            sous_activite_old.setActiv_id(sous_activite_new.getActiv_id());  
            
            
            sous_activite_old.setHorodatage();
            return sous_activiteRepository.save(sous_activite_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(Integer ssact_id_old)
        {
            sous_activiteRepository.deleteById(ssact_id_old);
        }

    }
