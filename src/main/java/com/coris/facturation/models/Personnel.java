 
        package com.coris.facturation.models;
  
        import jakarta.persistence.*;
        import jakarta.validation.constraints.*;
        import lombok.EqualsAndHashCode;
        import java.sql.Date;
        import lombok.Data;
         

@Data
@Entity
@Table(name = "personnel")

      @EqualsAndHashCode(callSuper = false)
      public class Personnel extends Horodatable {




        
        
        public Personnel ()
        {
            super();
        }
        
          @Id 
  @Size(min = 2, max=255)
  @Column(name = "matricule")
  private String matricule;

  @Column(name = "direct_id")
  private Integer direct_id;

  @Size(min = 2, max=255)
  @Column(name = "pers_nom")
  private String pers_nom;

  @Size(min = 2, max=255)
  @Column(name = "pers_prenom")
  private String pers_prenom;

  @Size(min = 2, max=255)
  @Column(name = "pers_email")
  private String pers_email;

  @Temporal(TemporalType.DATE)
  @Column(name = "pers_date_integration")
  private Date pers_date_integration;

  @Size(min = 2, max=255)
  @Column(name = "Supp_code")
  private String Supp_code;

}