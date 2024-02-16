

package com.coris.facturation.repositories;

import com.coris.facturation.models.Personnel;

import org.springframework.data.jpa.repository.JpaRepository;
  
// Interface
    public interface PersonnelRepository extends JpaRepository<Personnel, String> { 

    
    }
