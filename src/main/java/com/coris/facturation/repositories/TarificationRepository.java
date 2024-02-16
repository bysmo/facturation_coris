
package com.coris.facturation.repositories;

import com.coris.facturation.models.Tarification;
import com.coris.facturation.models.TarificationPK;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface
public interface TarificationRepository extends JpaRepository<Tarification, TarificationPK> {

}
