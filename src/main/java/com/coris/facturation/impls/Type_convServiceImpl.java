

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.Type_convRepository;
import com.coris.facturation.models.Type_conv;
import com.coris.facturation.services.IType_convService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class Type_convServiceImpl implements IType_convService { 

        @Autowired
        private Type_convRepository type_convRepository;
      
        // Create operation
        @Override
        @Transactional
        public Type_conv create(Type_conv type_conv_new)
        {
            type_conv_new.setHorodatage();
            return type_convRepository.save(type_conv_new);
        }
      
        // Read all data
        @Override
        public List<Type_conv> readAll()
        {
            return (List<Type_conv>)
            type_convRepository.findAll();
        }


        // Read all data
        @Override
        public List<Type_conv> findAll()
        {
            return (List<Type_conv>)
            type_convRepository.findAll();
        }


        @Override
        public Type_conv readOneById(Integer conv_id)
        {
            return type_convRepository.findById(conv_id).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Type_conv
        update (Type_conv type_conv_new,
          Integer conv_id_old)
        {
            Type_conv type_conv_old
                = type_convRepository.findById(conv_id_old).get();
            
        
          
            // mettre à jour la proriété Conv_id, Integer qui ne doit pas être null ou vide
          if (Objects.nonNull(type_conv_new.getConv_id())) {
                      type_conv_old.setConv_id(
                    type_conv_new.getConv_id());
            }

          
          // mettre à jour la proriété Conv_code, String qui ne doit pas être null ou vide
          if (Objects.nonNull(type_conv_new.getConv_code())
                && !"".equalsIgnoreCase(
                    type_conv_new.getConv_code())) {
                      type_conv_old.setConv_code(
                    type_conv_new.getConv_code());
            }

          
            // mettre à jour la proriété Conv_libelle, String qui peut être null ou vide
            type_conv_old.setConv_libelle(type_conv_new.getConv_libelle());  
            
            
            type_conv_old.setHorodatage();
            return type_convRepository.save(type_conv_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(Integer conv_id_old)
        {
            type_convRepository.deleteById(conv_id_old);
        }

    }
