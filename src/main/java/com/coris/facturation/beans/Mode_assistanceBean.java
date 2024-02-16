 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class Mode_assistanceBean {



private Integer assmod_id;

private String assmod_code;

private String assmod_libelle;

private String assmod_description;

private String assmod_canal;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}