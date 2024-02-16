

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Type_conv;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IType_convService { 

        // Save operation
        Type_conv create (Type_conv type_conv);
      
        // Read all data
        List<Type_conv> readAll();

        // Read all data
        List<Type_conv> findAll();


        // Read all data
       // List<Type_conv> findByAttribute1(String params);

        // Read operation
        Type_conv readOneById(Integer conv_id);

      
        // Update operation
        Type_conv update(Type_conv type_conv,Integer conv_id);
      
        // Delete operation
        void delete(Integer conv_id);

    }
