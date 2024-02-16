
package com.coris.facturation.repositories;

import com.coris.facturation.models.Affectation;
import com.coris.facturation.models.AffectationPK;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface
public interface AffectationRepository extends JpaRepository<Affectation, AffectationPK> {

}
