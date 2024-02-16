

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Filiale;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IFilialeService { 

        // Save operation
        Filiale create (Filiale filiale);
      
        // Read all data
        List<Filiale> readAll();

        // Read all data
        List<Filiale> findAll();


        // Read all data
       // List<Filiale> findByAttribute1(String params);

        // Read operation
        Filiale readOneById(Integer filiale_id);

      
        // Update operation
        Filiale update(Filiale filiale,Integer filiale_id);
      
        // Delete operation
        void delete(Integer filiale_id);

    }
