

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.DirectionRepository;
import com.coris.facturation.models.Direction;
import com.coris.facturation.services.IDirectionService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class DirectionServiceImpl implements IDirectionService { 

        @Autowired
        private DirectionRepository directionRepository;
      
        // Create operation
        @Override
        @Transactional
        public Direction create(Direction direction_new)
        {
            direction_new.setHorodatage();
            return directionRepository.save(direction_new);
        }
      
        // Read all data
        @Override
        public List<Direction> readAll()
        {
            return (List<Direction>)
            directionRepository.findAll();
        }


        // Read all data
        @Override
        public List<Direction> findAll()
        {
            return (List<Direction>)
            directionRepository.findAll();
        }


        @Override
        public Direction readOneById(Integer direct_id)
        {
            return directionRepository.findById(direct_id).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Direction
        update (Direction direction_new,
          Integer direct_id_old)
        {
            Direction direction_old
                = directionRepository.findById(direct_id_old).get();
            
        
          
            // mettre à jour la proriété Direct_id, Integer qui ne doit pas être null ou vide
          if (Objects.nonNull(direction_new.getDirect_id())) {
                      direction_old.setDirect_id(
                    direction_new.getDirect_id());
            }

          
            // mettre à jour la proriété Matricule_directeur, String qui peut être null ou vide
            direction_old.setMatricule_directeur(direction_new.getMatricule_directeur());  
            
          // mettre à jour la proriété Direct_code, String qui ne doit pas être null ou vide
          if (Objects.nonNull(direction_new.getDirect_code())
                && !"".equalsIgnoreCase(
                    direction_new.getDirect_code())) {
                      direction_old.setDirect_code(
                    direction_new.getDirect_code());
            }

          
          // mettre à jour la proriété Direct_libelle, String qui ne doit pas être null ou vide
          if (Objects.nonNull(direction_new.getDirect_libelle())
                && !"".equalsIgnoreCase(
                    direction_new.getDirect_libelle())) {
                      direction_old.setDirect_libelle(
                    direction_new.getDirect_libelle());
            }

          
            // mettre à jour la proriété Direct_description, String qui peut être null ou vide
            direction_old.setDirect_description(direction_new.getDirect_description());  
            
            
            direction_old.setHorodatage();
            return directionRepository.save(direction_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(Integer direct_id_old)
        {
            directionRepository.deleteById(direct_id_old);
        }

    }
