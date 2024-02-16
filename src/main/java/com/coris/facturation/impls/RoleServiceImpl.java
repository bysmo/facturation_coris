

package com.coris.facturation.impls;

// Importing required classes

import com.coris.facturation.repositories.RoleRepository;
import com.coris.facturation.models.Role;
import com.coris.facturation.services.IRoleService;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class RoleServiceImpl implements IRoleService { 

        @Autowired
        private RoleRepository roleRepository;
      
        // Create operation
        @Override
        @Transactional
        public Role create(Role role_new)
        {
            role_new.setHorodatage();
            return roleRepository.save(role_new);
        }
      
        // Read all data
        @Override
        public List<Role> readAll()
        {
            return (List<Role>)
            roleRepository.findAll();
        }


        // Read all data
        @Override
        public List<Role> findAll()
        {
            return (List<Role>)
            roleRepository.findAll();
        }


        @Override
        public Role readOneById(String role_id)
        {
            return roleRepository.findById(role_id).orElse(null);
        }
      
        // Update operation
        @Override
        @Transactional
        public Role
        update (Role role_new,
          String role_id_old)
        {
            Role role_old
                = roleRepository.findById(role_id_old).get();
            
        
          // mettre à jour la proriété Role_id, String qui ne doit pas être null ou vide
          if (Objects.nonNull(role_new.getRole_id())
                && !"".equalsIgnoreCase(
                    role_new.getRole_id())) {
                      role_old.setRole_id(
                    role_new.getRole_id());
            }

          
            // mettre à jour la proriété Role_name, String qui peut être null ou vide
            role_old.setRole_name(role_new.getRole_name());  
            
            
            role_old.setHorodatage();
            return roleRepository.save(role_old);
        }
      
        // Delete operation
        @Override
        @Transactional
        public void delete(String role_id_old)
        {
            roleRepository.deleteById(role_id_old);
        }

    }
