 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class ParamsBean {



private String PARAMCODE;

private String PARAMVALEUR;

private String PARAMDESCRIPTION;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}