

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.Mode_assistanceRepository;
import com.coris.facturation.models.Mode_assistance;
import com.coris.facturation.services.IMode_assistanceService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class Mode_assistanceServiceImpl implements IMode_assistanceService { 

        @Autowired
        private Mode_assistanceRepository mode_assistanceRepository;
      
        // Create operation
        @Override
        @Transactional
        public Mode_assistance create(Mode_assistance mode_assistance_new)
        {
            mode_assistance_new.setHorodatage();
            return mode_assistanceRepository.save(mode_assistance_new);
        }
      
        // Read all data
        @Override
        public List<Mode_assistance> readAll()
        {
            return (List<Mode_assistance>)
            mode_assistanceRepository.findAll();
        }


        // Read all data
        @Override
        public List<Mode_assistance> findAll()
        {
            return (List<Mode_assistance>)
            mode_assistanceRepository.findAll();
        }


        @Override
        public Mode_assistance readOneById(Integer assmod_id)
        {
            return mode_assistanceRepository.findById(assmod_id).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Mode_assistance
        update (Mode_assistance mode_assistance_new,
          Integer assmod_id_old)
        {
            Mode_assistance mode_assistance_old
                = mode_assistanceRepository.findById(assmod_id_old).get();
            
        
          
            // mettre à jour la proriété Assmod_id, Integer qui ne doit pas être null ou vide
          if (Objects.nonNull(mode_assistance_new.getAssmod_id())) {
                      mode_assistance_old.setAssmod_id(
                    mode_assistance_new.getAssmod_id());
            }

          
          // mettre à jour la proriété Assmod_code, String qui ne doit pas être null ou vide
          if (Objects.nonNull(mode_assistance_new.getAssmod_code())
                && !"".equalsIgnoreCase(
                    mode_assistance_new.getAssmod_code())) {
                      mode_assistance_old.setAssmod_code(
                    mode_assistance_new.getAssmod_code());
            }

          
          // mettre à jour la proriété Assmod_libelle, String qui ne doit pas être null ou vide
          if (Objects.nonNull(mode_assistance_new.getAssmod_libelle())
                && !"".equalsIgnoreCase(
                    mode_assistance_new.getAssmod_libelle())) {
                      mode_assistance_old.setAssmod_libelle(
                    mode_assistance_new.getAssmod_libelle());
            }

          
            // mettre à jour la proriété Assmod_description, String qui peut être null ou vide
            mode_assistance_old.setAssmod_description(mode_assistance_new.getAssmod_description());  
            
          // mettre à jour la proriété Assmod_canal, String qui ne doit pas être null ou vide
          if (Objects.nonNull(mode_assistance_new.getAssmod_canal())
                && !"".equalsIgnoreCase(
                    mode_assistance_new.getAssmod_canal())) {
                      mode_assistance_old.setAssmod_canal(
                    mode_assistance_new.getAssmod_canal());
            }

          
            
            mode_assistance_old.setHorodatage();
            return mode_assistanceRepository.save(mode_assistance_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(Integer assmod_id_old)
        {
            mode_assistanceRepository.deleteById(assmod_id_old);
        }

    }
