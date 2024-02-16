

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Type_tarif;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IType_tarifService { 

        // Save operation
        Type_tarif create (Type_tarif type_tarif);
      
        // Read all data
        List<Type_tarif> readAll();

        // Read all data
        List<Type_tarif> findAll();


        // Read all data
       // List<Type_tarif> findByAttribute1(String params);

        // Read operation
        Type_tarif readOneById(String tarif_code);

      
        // Update operation
        Type_tarif update(Type_tarif type_tarif,String tarif_code);
      
        // Delete operation
        void delete(String tarif_code);

    }
