 
        package com.coris.facturation.models;
  
        import jakarta.persistence.*;
        import jakarta.validation.constraints.*;
        import lombok.EqualsAndHashCode;
        import java.sql.Date;
        import lombok.Data;
         

@Data
@Entity
@Table(name = "realisation")

      @EqualsAndHashCode(callSuper = false)
      public class Realisation extends Horodatable {




        
        
        public Realisation ()
        {
            super();
        }
        
          @Id 
  @Column(name = "real_id")
  private Long real_id;

  @Column(name = "ssact_id")
  private Integer ssact_id;

  @Column(name = "activ_id")
  private Integer activ_id;

  @Column(name = "MONTANT_TARIF")
  private Double MONTANT_TARIF;

  @Size(min = 2, max=50)
  @Column(name = "STATCODE")
  private String STATCODE;

  @Temporal(TemporalType.DATE)
  @Column(name = "real_date_debut")
  private Date real_date_debut;

  @Temporal(TemporalType.DATE)
  @Column(name = "real_date_fin")
  private Date real_date_fin;

  @Column(name = "real_duree_jours")
  private Integer real_duree_jours;

  @Column(name = "real_duree_heures")
  private Integer real_duree_heures;

  @Column(name = "real_nombre_dossiers")
  private Integer real_nombre_dossiers;

  @Size(min = 2, max=255)
  @Column(name = "canal_assistance_details")
  private String canal_assistance_details;

  @Size(min = 2, max=255)
  @Column(name = "commentaire")
  private String commentaire;

  @Size(min = 2, max=255)
  @Column(name = "PJ")
  private String PJ;

  @Size(min = 2, max=255)
  @Column(name = "Matricule")
  private String Matricule;

  @Column(name = "Assmod_id")
  private Integer Assmod_id;

  @Column(name = "Conv_id")
  private Integer Conv_id;

  @Size(min = 2, max=255)
  @Column(name = "Supp_code")
  private String Supp_code;

  @Size(min = 2, max=50)
  @Column(name = "Tarif_code")
  private String Tarif_code;

  @Column(name = "MONTANT_TOTAL")
  private Double MONTANT_TOTAL;

  @Column(name = "user_decision")
  private Integer user_decision;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_decision")
  private Date date_decision;

  @Size(min = 2, max=255)
  @Column(name = "motif_decision")
  private String motif_decision;

}