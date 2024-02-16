

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.Type_tarifRepository;
import com.coris.facturation.models.Type_tarif;
import com.coris.facturation.services.IType_tarifService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class Type_tarifServiceImpl implements IType_tarifService { 

        @Autowired
        private Type_tarifRepository type_tarifRepository;
      
        // Create operation
        @Override
        @Transactional
        public Type_tarif create(Type_tarif type_tarif_new)
        {
            type_tarif_new.setHorodatage();
            return type_tarifRepository.save(type_tarif_new);
        }
      
        // Read all data
        @Override
        public List<Type_tarif> readAll()
        {
            return (List<Type_tarif>)
            type_tarifRepository.findAll();
        }


        // Read all data
        @Override
        public List<Type_tarif> findAll()
        {
            return (List<Type_tarif>)
            type_tarifRepository.findAll();
        }


        @Override
        public Type_tarif readOneById(String tarif_code)
        {
            return type_tarifRepository.findById(tarif_code).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Type_tarif
        update (Type_tarif type_tarif_new,
          String tarif_code_old)
        {
            Type_tarif type_tarif_old
                = type_tarifRepository.findById(tarif_code_old).get();
            
        
          // mettre à jour la proriété Tarif_code, String qui ne doit pas être null ou vide
          if (Objects.nonNull(type_tarif_new.getTarif_code())
                && !"".equalsIgnoreCase(
                    type_tarif_new.getTarif_code())) {
                      type_tarif_old.setTarif_code(
                    type_tarif_new.getTarif_code());
            }

          
            // mettre à jour la proriété Tarif_libelle, String qui peut être null ou vide
            type_tarif_old.setTarif_libelle(type_tarif_new.getTarif_libelle());  
            
            // mettre à jour la proriété Tarif_description, String qui peut être null ou vide
            type_tarif_old.setTarif_description(type_tarif_new.getTarif_description());  
            
            
            type_tarif_old.setHorodatage();
            return type_tarifRepository.save(type_tarif_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(String tarif_code_old)
        {
            type_tarifRepository.deleteById(tarif_code_old);
        }

    }
