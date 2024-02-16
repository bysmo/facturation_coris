

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.ParamsRepository;
import com.coris.facturation.models.Params;
import com.coris.facturation.services.IParamsService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class ParamsServiceImpl implements IParamsService { 

        @Autowired
        private ParamsRepository paramsRepository;
      
        // Create operation
        @Override
        @Transactional
        public Params create(Params params_new)
        {
            params_new.setHorodatage();
            return paramsRepository.save(params_new);
        }
      
        // Read all data
        @Override
        public List<Params> readAll()
        {
            return (List<Params>)
            paramsRepository.findAll();
        }


        // Read all data
        @Override
        public List<Params> findAll()
        {
            return (List<Params>)
            paramsRepository.findAll();
        }


        @Override
        public Params readOneById(String PARAMCODE)
        {
            return paramsRepository.findById(PARAMCODE).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Params
        update (Params params_new,
          String PARAMCODE_old)
        {
            Params params_old
                = paramsRepository.findById(PARAMCODE_old).get();
            
        
          // mettre à jour la proriété PARAMCODE, String qui ne doit pas être null ou vide
          if (Objects.nonNull(params_new.getPARAMCODE())
                && !"".equalsIgnoreCase(
                    params_new.getPARAMCODE())) {
                      params_old.setPARAMCODE(
                    params_new.getPARAMCODE());
            }

          
            // mettre à jour la proriété PARAMVALEUR, String qui peut être null ou vide
            params_old.setPARAMVALEUR(params_new.getPARAMVALEUR());  
            
            // mettre à jour la proriété PARAMDESCRIPTION, String qui peut être null ou vide
            params_old.setPARAMDESCRIPTION(params_new.getPARAMDESCRIPTION());  
            
            
            params_old.setHorodatage();
            return paramsRepository.save(params_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(String PARAMCODE_old)
        {
            paramsRepository.deleteById(PARAMCODE_old);
        }

    }
