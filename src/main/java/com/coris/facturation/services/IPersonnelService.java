

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Personnel;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IPersonnelService { 

        // Save operation
        Personnel create (Personnel personnel);
      
        // Read all data
        List<Personnel> readAll();

        // Read all data
        List<Personnel> findAll();


        // Read all data
       // List<Personnel> findByAttribute1(String params);

        // Read operation
        Personnel readOneById(String matricule);

      
        // Update operation
        Personnel update(Personnel personnel,String matricule);
      
        // Delete operation
        void delete(String matricule);

    }
