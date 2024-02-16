
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "tarification")

@EqualsAndHashCode(callSuper = false)
public class Tarification extends Horodatable {

  public Tarification() {
    super();
  }

  @EmbeddedId
  private TarificationPK tarificationPK;

  @Null
  @Column(name = "MONTANT_TARIF")
  private Double MONTANT_TARIF;

}