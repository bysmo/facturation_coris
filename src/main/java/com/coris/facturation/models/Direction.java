
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "direction")

@EqualsAndHashCode(callSuper = false)
public class Direction extends Horodatable {

  public Direction() {
    super();
  }

  @Id
  @Column(name = "direct_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer direct_id;

  @Size(min = 2, max = 255)
  @Column(name = "Matricule_directeur")
  private String Matricule_directeur;

  @Size(min = 2, max = 50)
  @Column(name = "direct_code")
  private String direct_code;

  @Size(min = 2, max = 50)
  @Column(name = "direct_libelle")
  private String direct_libelle;

  @Size(min = 2, max = 50)
  @Column(name = "direct_description")
  private String direct_description;

}