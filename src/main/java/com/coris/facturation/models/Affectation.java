
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "affectation")

@EqualsAndHashCode(callSuper = false)
public class Affectation extends Horodatable {

  public Affectation() {
    super();
  }

  @EmbeddedId
  private AffectationPK affectationPK;

  @Null
  @Column(name = "cle_repartition")
  private Integer cle_repartition;

  @Null
  @Size(min = 2, max = 255)
  @Column(name = "PJ_filiale")
  private String PJ_filiale;

}
