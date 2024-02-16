
package com.coris.facturation.repositories;

import com.coris.facturation.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByRole_id(String role_id);

    Role findByRole_name(String role_name);
}
