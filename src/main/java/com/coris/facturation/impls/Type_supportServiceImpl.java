

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.Type_supportRepository;
import com.coris.facturation.models.Type_support;
import com.coris.facturation.services.IType_supportService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class Type_supportServiceImpl implements IType_supportService { 

        @Autowired
        private Type_supportRepository type_supportRepository;
      
        // Create operation
        @Override
        @Transactional
        public Type_support create(Type_support type_support_new)
        {
            type_support_new.setHorodatage();
            return type_supportRepository.save(type_support_new);
        }
      
        // Read all data
        @Override
        public List<Type_support> readAll()
        {
            return (List<Type_support>)
            type_supportRepository.findAll();
        }


        // Read all data
        @Override
        public List<Type_support> findAll()
        {
            return (List<Type_support>)
            type_supportRepository.findAll();
        }


        @Override
        public Type_support readOneById(String supp_code)
        {
            return type_supportRepository.findById(supp_code).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Type_support
        update (Type_support type_support_new,
          String supp_code_old)
        {
            Type_support type_support_old
                = type_supportRepository.findById(supp_code_old).get();
            
        
          // mettre à jour la proriété Supp_code, String qui ne doit pas être null ou vide
          if (Objects.nonNull(type_support_new.getSupp_code())
                && !"".equalsIgnoreCase(
                    type_support_new.getSupp_code())) {
                      type_support_old.setSupp_code(
                    type_support_new.getSupp_code());
            }

          
            // mettre à jour la proriété Supp_libelle, String qui peut être null ou vide
            type_support_old.setSupp_libelle(type_support_new.getSupp_libelle());  
            
            // mettre à jour la proriété Supp_contenu, String qui peut être null ou vide
            type_support_old.setSupp_contenu(type_support_new.getSupp_contenu());  
            
            
            type_support_old.setHorodatage();
            return type_supportRepository.save(type_support_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(String supp_code_old)
        {
            type_supportRepository.deleteById(supp_code_old);
        }

    }
