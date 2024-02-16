
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "type_support")

@EqualsAndHashCode(callSuper = false)
public class Type_support extends Horodatable {

  public Type_support() {
    super();
  }

  @Id
  @Size(min = 2, max = 255)
  @Column(name = "supp_code")
  private String supp_code;

  @Size(min = 2, max = 255)
  @Column(name = "supp_libelle")
  private String supp_libelle;

  @Size(min = 2, max = 255)
  @Column(name = "supp_contenu")
  private String supp_contenu;

}