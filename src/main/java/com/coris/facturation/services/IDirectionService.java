

    package com.coris.facturation.services;

    import java.util.List;
    import com.coris.facturation.models.Direction;
    import org.springframework.stereotype.Service;
  
    @Service
    public interface IDirectionService { 

        // Save operation
        Direction create (Direction direction);
      
        // Read all data
        List<Direction> readAll();

        // Read all data
        List<Direction> findAll();


        // Read all data
       // List<Direction> findByAttribute1(String params);

        // Read operation
        Direction readOneById(Integer direct_id);

      
        // Update operation
        Direction update(Direction direction,Integer direct_id);
      
        // Delete operation
        void delete(Integer direct_id);

    }
