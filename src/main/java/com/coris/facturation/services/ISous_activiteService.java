

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Sous_activite;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface ISous_activiteService { 

        // Save operation
        Sous_activite create (Sous_activite sous_activite);
      
        // Read all data
        List<Sous_activite> readAll();

        // Read all data
        List<Sous_activite> findAll();


        // Read all data
       // List<Sous_activite> findByAttribute1(String params);

        // Read operation
        Sous_activite readOneById(Integer ssact_id);

      
        // Update operation
        Sous_activite update(Sous_activite sous_activite,Integer ssact_id);
      
        // Delete operation
        void delete(Integer ssact_id);

    }
