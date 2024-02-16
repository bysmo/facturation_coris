 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class RealisationBean {



private Long real_id;

private Integer ssact_id;

private Integer activ_id;

private Double MONTANT_TARIF;

private String STATCODE;

private Date real_date_debut;

private Date real_date_fin;

private Integer real_duree_jours;

private Integer real_duree_heures;

private Integer real_nombre_dossiers;

private String canal_assistance_details;

private String commentaire;

private String PJ;

private String Matricule;

private Integer Assmod_id;

private Integer Conv_id;

private String Supp_code;

private String Tarif_code;

private Double MONTANT_TOTAL;

private Integer user_decision;

private Date date_decision;

private String motif_decision;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}