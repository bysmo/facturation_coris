
        package com.coris.facturation.models;
  
        
import java.sql.Date;
import jakarta.persistence.Column;

public class Horodatable {

    @Column(name = "date_creation")
    private Date date_creation;

    @Column(name = "user_creation")
    private Integer user_creation;

    @Column(name = "date_modification")
    private Date date_modification;

    @Column(name = "user_modification")
    private Integer user_modification;

    @Column(name = "NIVEAU_ACCES")
    private Integer NIVEAU_ACCES;

    public void setHorodatage() {
        Date ddate = new Date(System.currentTimeMillis());
        date_creation = ddate;
        date_modification = ddate;
        user_creation = 1;
        user_modification = 1;
        NIVEAU_ACCES = 1;

    }
}

    