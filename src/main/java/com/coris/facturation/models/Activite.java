
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "activite")

@EqualsAndHashCode(callSuper = false)
public class Activite extends Horodatable {

  public Activite() {
    super();
  }

  @Id
  @Column(name = "activ_id")
  private Integer activ_id;

  @Column(name = "id_direction")
  private Integer id_direction;

  @Size(min = 2, max = 50)
  @Column(name = "activ_code")
  private String activ_code;

  @Size(min = 2, max = 255)
  @Column(name = "activ_libelle")
  private String activ_libelle;

  @Size(min = 2, max = 255)
  @Column(name = "activ_description")
  private String activ_description;

}