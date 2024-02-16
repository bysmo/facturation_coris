
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "type_tarif")

@EqualsAndHashCode(callSuper = false)
public class Type_tarif extends Horodatable {

  public Type_tarif() {
    super();
  }

  @Id
  @Size(min = 2, max = 50)
  @Column(name = "tarif_code")
  private String tarif_code;

  @Size(min = 2, max = 255)
  @Column(name = "tarif_libelle")
  private String tarif_libelle;

  @Size(min = 2, max = 255)
  @Column(name = "tarif_description")
  private String tarif_description;

}