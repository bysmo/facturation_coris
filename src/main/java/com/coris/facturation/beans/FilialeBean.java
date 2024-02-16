 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class FilialeBean {



private Integer filiale_id;

private String filiale_code;

private String filiale_libelle;

private String adress_geo;

private String num_fisc;

private String boite_postale;

private String telephone;

private String registre_com;

private String pays;

private String ville;

private String signature;

private String nom_signataire;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}