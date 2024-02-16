

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Type_support;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IType_supportService { 

        // Save operation
        Type_support create (Type_support type_support);
      
        // Read all data
        List<Type_support> readAll();

        // Read all data
        List<Type_support> findAll();


        // Read all data
       // List<Type_support> findByAttribute1(String params);

        // Read operation
        Type_support readOneById(String supp_code);

      
        // Update operation
        Type_support update(Type_support type_support,String supp_code);
      
        // Delete operation
        void delete(String supp_code);

    }
