

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Mode_assistance;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IMode_assistanceService { 

        // Save operation
        Mode_assistance create (Mode_assistance mode_assistance);
      
        // Read all data
        List<Mode_assistance> readAll();

        // Read all data
        List<Mode_assistance> findAll();


        // Read all data
       // List<Mode_assistance> findByAttribute1(String params);

        // Read operation
        Mode_assistance readOneById(Integer assmod_id);

      
        // Update operation
        Mode_assistance update(Mode_assistance mode_assistance,Integer assmod_id);
      
        // Delete operation
        void delete(Integer assmod_id);

    }
