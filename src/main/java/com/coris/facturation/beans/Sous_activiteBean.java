 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class Sous_activiteBean {



private Integer ssact_id;

private String ssact_code;

private String ssact_libelle;

private String ssact_description;

private Integer activ_id;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}