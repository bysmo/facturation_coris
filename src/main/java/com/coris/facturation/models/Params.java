
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "params")

@EqualsAndHashCode(callSuper = false)
public class Params extends Horodatable {

  public Params() {
    super();
  }

  @Id
  @Size(min = 2, max = 100)
  @Column(name = "PARAMCODE")
  private String PARAMCODE;

  @Size(min = 2, max = 255)
  @Column(name = "PARAMVALEUR")
  private String PARAMVALEUR;

  @Size(min = 2, max = 255)
  @Column(name = "PARAMDESCRIPTION")
  private String PARAMDESCRIPTION;

}