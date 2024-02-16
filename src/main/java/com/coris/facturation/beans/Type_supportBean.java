 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class Type_supportBean {



private String supp_code;

private String supp_libelle;

private String supp_contenu;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}