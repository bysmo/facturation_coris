
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "sous_activite")

@EqualsAndHashCode(callSuper = false)
public class Sous_activite extends Horodatable {

  public Sous_activite() {
    super();
  }

  @Id
  @Column(name = "ssact_id")
  private Integer ssact_id;

  @Size(min = 2, max = 255)
  @Column(name = "ssact_code")
  private String ssact_code;

  @Size(min = 2, max = 50)
  @Column(name = "ssact_libelle")
  private String ssact_libelle;

  @Size(min = 2, max = 50)
  @Column(name = "ssact_description")
  private String ssact_description;

  @Column(name = "activ_id")
  private Integer activ_id;

}