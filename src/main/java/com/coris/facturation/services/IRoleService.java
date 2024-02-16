

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Role;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IRoleService { 

        // Save operation
        Role create (Role role);
      
        // Read all data
        List<Role> readAll();

        // Read all data
        List<Role> findAll();


        // Read all data
       // List<Role> findByAttribute1(String params);

        // Read operation
        Role readOneById(String role_id);

      
        // Update operation
        Role update(Role role,String role_id);
      
        // Delete operation
        void delete(String role_id);

        

    }
