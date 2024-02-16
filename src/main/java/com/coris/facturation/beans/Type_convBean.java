 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class Type_convBean {



private Integer conv_id;

private String conv_code;

private String conv_libelle;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}