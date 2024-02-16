

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.ActiviteRepository;
import com.coris.facturation.models.Activite;
import com.coris.facturation.services.IActiviteService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class ActiviteServiceImpl implements IActiviteService { 

        @Autowired
        private ActiviteRepository activiteRepository;
      
        // Create operation
        @Override
        @Transactional
        public Activite create(Activite activite_new)
        {
            activite_new.setHorodatage();
            return activiteRepository.save(activite_new);
        }
      
        // Read all data
        @Override
        public List<Activite> readAll()
        {
            return (List<Activite>)
            activiteRepository.findAll();
        }


        // Read all data
        @Override
        public List<Activite> findAll()
        {
            return (List<Activite>)
            activiteRepository.findAll();
        }


        @Override
        public Activite readOneById(Integer activ_id)
        {
            return activiteRepository.findById(activ_id).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Activite
        update (Activite activite_new,
          Integer activ_id_old)
        {
            Activite activite_old
                = activiteRepository.findById(activ_id_old).get();
            
        
          
            // mettre à jour la proriété Activ_id, Integer qui ne doit pas être null ou vide
          if (Objects.nonNull(activite_new.getActiv_id())) {
                      activite_old.setActiv_id(
                    activite_new.getActiv_id());
            }

          
            // mettre à jour la proriété Id_direction, Integer qui peut être null ou vide
            activite_old.setId_direction(activite_new.getId_direction());  
            
          // mettre à jour la proriété Activ_code, String qui ne doit pas être null ou vide
          if (Objects.nonNull(activite_new.getActiv_code())
                && !"".equalsIgnoreCase(
                    activite_new.getActiv_code())) {
                      activite_old.setActiv_code(
                    activite_new.getActiv_code());
            }

          
          // mettre à jour la proriété Activ_libelle, String qui ne doit pas être null ou vide
          if (Objects.nonNull(activite_new.getActiv_libelle())
                && !"".equalsIgnoreCase(
                    activite_new.getActiv_libelle())) {
                      activite_old.setActiv_libelle(
                    activite_new.getActiv_libelle());
            }

          
            // mettre à jour la proriété Activ_description, String qui peut être null ou vide
            activite_old.setActiv_description(activite_new.getActiv_description());  
            
            
            activite_old.setHorodatage();
            return activiteRepository.save(activite_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(Integer activ_id_old)
        {
            activiteRepository.deleteById(activ_id_old);
        }

    }
