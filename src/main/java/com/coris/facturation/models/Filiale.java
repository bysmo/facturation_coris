
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "filiale")

@EqualsAndHashCode(callSuper = false)
public class Filiale extends Horodatable {

  public Filiale() {
    super();
  }

  @Id
  @Column(name = "filiale_id")
  private Integer filiale_id;

  @Size(min = 2, max = 255)
  @Column(name = "filiale_code")
  private String filiale_code;

  @Size(min = 2, max = 255)
  @Column(name = "filiale_libelle")
  private String filiale_libelle;

  @Size(min = 2, max = 255)
  @Column(name = "adress_geo")
  private String adress_geo;

  @Size(min = 2, max = 255)
  @Column(name = "num_fisc")
  private String num_fisc;

  @Size(min = 2, max = 255)
  @Column(name = "boite_postale")
  private String boite_postale;

  @Size(min = 2, max = 255)
  @Column(name = "telephone")
  private String telephone;

  @Size(min = 2, max = 255)
  @Column(name = "registre_com")
  private String registre_com;

  @Size(min = 2, max = 255)
  @Column(name = "pays")
  private String pays;

  @Size(min = 2, max = 255)
  @Column(name = "ville")
  private String ville;

  @Size(min = 2, max = 255)
  @Column(name = "signature")
  private String signature;

  @Size(min = 2, max = 255)
  @Column(name = "nom_signataire")
  private String nom_signataire;

}