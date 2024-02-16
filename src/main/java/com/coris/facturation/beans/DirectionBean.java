 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class DirectionBean {



private Integer direct_id;

private String Matricule_directeur;

private String direct_code;

private String direct_libelle;

private String direct_description;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}