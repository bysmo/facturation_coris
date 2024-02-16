

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.RealisationRepository;
import com.coris.facturation.models.Realisation;
import com.coris.facturation.services.IRealisationService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class RealisationServiceImpl implements IRealisationService { 

        @Autowired
        private RealisationRepository realisationRepository;
      
        // Create operation
        @Override
        @Transactional
        public Realisation create(Realisation realisation_new)
        {
            realisation_new.setHorodatage();
            return realisationRepository.save(realisation_new);
        }
      
        // Read all data
        @Override
        public List<Realisation> readAll()
        {
            return (List<Realisation>)
            realisationRepository.findAll();
        }


        // Read all data
        @Override
        public List<Realisation> findAll()
        {
            return (List<Realisation>)
            realisationRepository.findAll();
        }


        @Override
        public Realisation readOneById(Long real_id)
        {
            return realisationRepository.findById(real_id).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Realisation
        update (Realisation realisation_new,
          Long real_id_old)
        {
            Realisation realisation_old
                = realisationRepository.findById(real_id_old).get();
            
        
          
            // mettre à jour la proriété Real_id, Long qui ne doit pas être null ou vide
          if (Objects.nonNull(realisation_new.getReal_id())) {
                      realisation_old.setReal_id(
                    realisation_new.getReal_id());
            }

          
            // mettre à jour la proriété Ssact_id, Integer qui peut être null ou vide
            realisation_old.setSsact_id(realisation_new.getSsact_id());  
            
            // mettre à jour la proriété Activ_id, Integer qui peut être null ou vide
            realisation_old.setActiv_id(realisation_new.getActiv_id());  
            
            // mettre à jour la proriété MONTANT_TARIF, Double qui peut être null ou vide
            realisation_old.setMONTANT_TARIF(realisation_new.getMONTANT_TARIF());  
            
          // mettre à jour la proriété STATCODE, String qui ne doit pas être null ou vide
          if (Objects.nonNull(realisation_new.getSTATCODE())
                && !"".equalsIgnoreCase(
                    realisation_new.getSTATCODE())) {
                      realisation_old.setSTATCODE(
                    realisation_new.getSTATCODE());
            }

          
            // mettre à jour la proriété Real_date_debut, Date qui peut être null ou vide
            realisation_old.setReal_date_debut(realisation_new.getReal_date_debut());  
            
            // mettre à jour la proriété Real_date_fin, Date qui peut être null ou vide
            realisation_old.setReal_date_fin(realisation_new.getReal_date_fin());  
            
            // mettre à jour la proriété Real_duree_jours, Integer qui peut être null ou vide
            realisation_old.setReal_duree_jours(realisation_new.getReal_duree_jours());  
            
            // mettre à jour la proriété Real_duree_heures, Integer qui peut être null ou vide
            realisation_old.setReal_duree_heures(realisation_new.getReal_duree_heures());  
            
            // mettre à jour la proriété Real_nombre_dossiers, Integer qui peut être null ou vide
            realisation_old.setReal_nombre_dossiers(realisation_new.getReal_nombre_dossiers());  
            
          // mettre à jour la proriété Canal_assistance_details, String qui ne doit pas être null ou vide
          if (Objects.nonNull(realisation_new.getCanal_assistance_details())
                && !"".equalsIgnoreCase(
                    realisation_new.getCanal_assistance_details())) {
                      realisation_old.setCanal_assistance_details(
                    realisation_new.getCanal_assistance_details());
            }

          
            // mettre à jour la proriété Commentaire, String qui peut être null ou vide
            realisation_old.setCommentaire(realisation_new.getCommentaire());  
            
            // mettre à jour la proriété PJ, String qui peut être null ou vide
            realisation_old.setPJ(realisation_new.getPJ());  
            
            // mettre à jour la proriété Matricule, String qui peut être null ou vide
            realisation_old.setMatricule(realisation_new.getMatricule());  
            
            // mettre à jour la proriété Assmod_id, Integer qui peut être null ou vide
            realisation_old.setAssmod_id(realisation_new.getAssmod_id());  
            
            // mettre à jour la proriété Conv_id, Integer qui peut être null ou vide
            realisation_old.setConv_id(realisation_new.getConv_id());  
            
            // mettre à jour la proriété Supp_code, String qui peut être null ou vide
            realisation_old.setSupp_code(realisation_new.getSupp_code());  
            
            // mettre à jour la proriété Tarif_code, String qui peut être null ou vide
            realisation_old.setTarif_code(realisation_new.getTarif_code());  
            
            // mettre à jour la proriété MONTANT_TOTAL, Double qui peut être null ou vide
            realisation_old.setMONTANT_TOTAL(realisation_new.getMONTANT_TOTAL());  
            
            // mettre à jour la proriété User_decision, Integer qui peut être null ou vide
            realisation_old.setUser_decision(realisation_new.getUser_decision());  
            
            // mettre à jour la proriété Date_decision, Date qui peut être null ou vide
            realisation_old.setDate_decision(realisation_new.getDate_decision());  
            
            // mettre à jour la proriété Motif_decision, String qui peut être null ou vide
            realisation_old.setMotif_decision(realisation_new.getMotif_decision());  
            
            
            realisation_old.setHorodatage();
            return realisationRepository.save(realisation_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(Long real_id_old)
        {
            realisationRepository.deleteById(real_id_old);
        }

    }
