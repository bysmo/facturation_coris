

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Realisation;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IRealisationService { 

        // Save operation
        Realisation create (Realisation realisation);
      
        // Read all data
        List<Realisation> readAll();

        // Read all data
        List<Realisation> findAll();


        // Read all data
       // List<Realisation> findByAttribute1(String params);

        // Read operation
        Realisation readOneById(Long real_id);

      
        // Update operation
        Realisation update(Realisation realisation,Long real_id);
      
        // Delete operation
        void delete(Long real_id);

    }
