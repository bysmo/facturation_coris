 
        package com.coris.facturation.beans;
  
        import java.sql.Date;
        import lombok.Data;
         


@Data
public class RoleBean {



private String role_id;

private String role_name;

private Date date_creation;

private Integer user_creation;

private Date date_modification;

private Integer user_modification;

private Integer NIVEAU_ACCES;

}