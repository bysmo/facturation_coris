

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Params;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IParamsService { 

        // Save operation
        Params create (Params params);
      
        // Read all data
        List<Params> readAll();

        // Read all data
        List<Params> findAll();


        // Read all data
       // List<Params> findByAttribute1(String params);

        // Read operation
        Params readOneById(String PARAMCODE);

      
        // Update operation
        Params update(Params params,String PARAMCODE);
      
        // Delete operation
        void delete(String PARAMCODE);

    }
