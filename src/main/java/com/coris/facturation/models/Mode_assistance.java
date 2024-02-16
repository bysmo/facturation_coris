
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "mode_assistance")

@EqualsAndHashCode(callSuper = false)
public class Mode_assistance extends Horodatable {

  public Mode_assistance() {
    super();
  }

  @Id
  @Column(name = "assmod_id")
  private Integer assmod_id;

  @Size(min = 2, max = 50)
  @Column(name = "assmod_code")
  private String assmod_code;

  @Size(min = 2, max = 255)
  @Column(name = "assmod_libelle")
  private String assmod_libelle;

  @Size(min = 2, max = 255)
  @Column(name = "assmod_description")
  private String assmod_description;

  @Size(min = 2, max = 255)
  @Column(name = "assmod_canal")
  private String assmod_canal;

}