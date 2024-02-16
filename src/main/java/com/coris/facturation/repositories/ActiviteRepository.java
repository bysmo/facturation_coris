

package com.coris.facturation.repositories;

import com.coris.facturation.models.Activite;

import org.springframework.data.jpa.repository.JpaRepository;
  
// Interface
    public interface ActiviteRepository extends JpaRepository<Activite, Integer> { 

    
    }
