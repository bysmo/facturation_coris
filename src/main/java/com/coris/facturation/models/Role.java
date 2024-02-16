
package com.coris.facturation.models;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "role")

@EqualsAndHashCode(callSuper = false)
public class Role extends Horodatable {

  public Role() {
    super();
  }

  @Id
  @Size(min = 2, max = 50)
  @Column(name = "role_id")
  private String role_id;

  @Size(min = 2, max = 200)
  @Column(name = "role_name")
  private String role_name;

  @ManyToMany(mappedBy = "roles")
  private List<Utilisateur> users;

}