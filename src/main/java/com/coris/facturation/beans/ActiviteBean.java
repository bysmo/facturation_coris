 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class ActiviteBean {



private Integer activ_id;

private Integer id_direction;

private String activ_code;

private String activ_libelle;

private String activ_description;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}