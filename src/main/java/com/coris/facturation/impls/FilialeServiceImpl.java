

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.FilialeRepository;
import com.coris.facturation.models.Filiale;
import com.coris.facturation.services.IFilialeService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class FilialeServiceImpl implements IFilialeService { 

        @Autowired
        private FilialeRepository filialeRepository;
      
        // Create operation
        @Override
        @Transactional
        public Filiale create(Filiale filiale_new)
        {
            filiale_new.setHorodatage();
            return filialeRepository.save(filiale_new);
        }
      
        // Read all data
        @Override
        public List<Filiale> readAll()
        {
            return (List<Filiale>)
            filialeRepository.findAll();
        }


        // Read all data
        @Override
        public List<Filiale> findAll()
        {
            return (List<Filiale>)
            filialeRepository.findAll();
        }


        @Override
        public Filiale readOneById(Integer filiale_id)
        {
            return filialeRepository.findById(filiale_id).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Filiale
        update (Filiale filiale_new,
          Integer filiale_id_old)
        {
            Filiale filiale_old
                = filialeRepository.findById(filiale_id_old).get();
            
        
          
            // mettre à jour la proriété Filiale_id, Integer qui ne doit pas être null ou vide
          if (Objects.nonNull(filiale_new.getFiliale_id())) {
                      filiale_old.setFiliale_id(
                    filiale_new.getFiliale_id());
            }

          
          // mettre à jour la proriété Filiale_code, String qui ne doit pas être null ou vide
          if (Objects.nonNull(filiale_new.getFiliale_code())
                && !"".equalsIgnoreCase(
                    filiale_new.getFiliale_code())) {
                      filiale_old.setFiliale_code(
                    filiale_new.getFiliale_code());
            }

          
          // mettre à jour la proriété Filiale_libelle, String qui ne doit pas être null ou vide
          if (Objects.nonNull(filiale_new.getFiliale_libelle())
                && !"".equalsIgnoreCase(
                    filiale_new.getFiliale_libelle())) {
                      filiale_old.setFiliale_libelle(
                    filiale_new.getFiliale_libelle());
            }

          
            // mettre à jour la proriété Adress_geo, String qui peut être null ou vide
            filiale_old.setAdress_geo(filiale_new.getAdress_geo());  
            
            // mettre à jour la proriété Num_fisc, String qui peut être null ou vide
            filiale_old.setNum_fisc(filiale_new.getNum_fisc());  
            
            // mettre à jour la proriété Boite_postale, String qui peut être null ou vide
            filiale_old.setBoite_postale(filiale_new.getBoite_postale());  
            
            // mettre à jour la proriété Telephone, String qui peut être null ou vide
            filiale_old.setTelephone(filiale_new.getTelephone());  
            
            // mettre à jour la proriété Registre_com, String qui peut être null ou vide
            filiale_old.setRegistre_com(filiale_new.getRegistre_com());  
            
            // mettre à jour la proriété Pays, String qui peut être null ou vide
            filiale_old.setPays(filiale_new.getPays());  
            
            // mettre à jour la proriété Ville, String qui peut être null ou vide
            filiale_old.setVille(filiale_new.getVille());  
            
            // mettre à jour la proriété Signature, String qui peut être null ou vide
            filiale_old.setSignature(filiale_new.getSignature());  
            
            // mettre à jour la proriété Nom_signataire, String qui peut être null ou vide
            filiale_old.setNom_signataire(filiale_new.getNom_signataire());  
            
            
            filiale_old.setHorodatage();
            return filialeRepository.save(filiale_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(Integer filiale_id_old)
        {
            filialeRepository.deleteById(filiale_id_old);
        }

    }
