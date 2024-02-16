
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "type_conv")

@EqualsAndHashCode(callSuper = false)
public class Type_conv extends Horodatable {

  public Type_conv() {
    super();
  }

  @Id
  @Column(name = "conv_id")
  private Integer conv_id;

  @Size(min = 2, max = 50)
  @Column(name = "conv_code")
  private String conv_code;

  @Size(min = 2, max = 255)
  @Column(name = "conv_libelle")
  private String conv_libelle;

}