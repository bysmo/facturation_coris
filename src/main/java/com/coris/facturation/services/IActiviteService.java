

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Activite;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IActiviteService { 

        // Save operation
        Activite create (Activite activite);
      
        // Read all data
        List<Activite> readAll();

        // Read all data
        List<Activite> findAll();


        // Read all data
       // List<Activite> findByAttribute1(String params);

        // Read operation
        Activite readOneById(Integer activ_id);

      
        // Update operation
        Activite update(Activite activite,Integer activ_id);
      
        // Delete operation
        void delete(Integer activ_id);

    }
