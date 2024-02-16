 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class PersonnelBean {



private String matricule;

private Integer direct_id;

private String pers_nom;

private String pers_prenom;

private String pers_email;

private Date pers_date_integration;

private String Supp_code;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}