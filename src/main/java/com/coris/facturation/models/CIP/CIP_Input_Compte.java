
package com.coris.facturation.models.CIP;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "cip_input_compte")

public class CIP_Input_Compte {

    public CIP_Input_Compte() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DATA_ID")
    private Long DATA_ID;

    @Size(min = 2, max = 15)
    @Column(name = "NUM_ENREG")
    private String NUM_ENREG;

    @Size(min = 2, max = 12)
    @Column(name = "NUM_CPTE")
    private String NUM_CPTE;

    @Size(min = 2, max = 15)
    @Column(name = "NUM_PARTICIP")
    private String NUM_PARTICIP;

    @Size(min = 2, max = 15)
    @Column(name = "CODE_AGENCE")
    private String CODE_AGENCE;

    @Size(min = 2, max = 15)
    @Column(name = "CODE_BANQUE")
    private String CODE_BANQUE;

    @Size(min = 2, max = 15)
    @Column(name = "CODE_GUICHET")
    private String CODE_GUICHET;

    @Size(min = 2, max = 15)
    @Column(name = "TYPE_CPTE")
    private String TYPE_CPTE;

    @Size(min = 2, max = 15)
    @Column(name = "NBR_PARTICIP")
    private String NBR_PARTICIP;

    @Size(min = 2, max = 15)
    @Column(name = "CLE_BCEAO")
    private String CLE_BCEAO;

    @Size(min = 2, max = 15)
    @Column(name = "TYPE_OPER")
    private String TYPE_OPER;

    @Size(min = 2, max = 15)
    @Column(name = "TYPE_CLT")
    private String TYPE_CLT;

    @Size(min = 2, max = 15)
    @Column(name = "CODE_UMOA")
    private String CODE_UMOA;

    @Size(min = 2, max = 60)
    @Column(name = "NOM_PP")
    private String NOM_PP;

    @Size(min = 2, max = 60)
    @Column(name = "PREN_PP")
    private String PREN_PP;

    @Size(min = 2, max = 60)
    @Column(name = "MARI_PP")
    private String MARI_PP;

    @Size(min = 2, max = 60)
    @Column(name = "MERE_PP")
    private String MERE_PP;

    @Size(min = 2, max = 60)
    @Column(name = "LIEU_NAISS_PP")
    private String LIEU_NAISS_PP;

    @Temporal(TemporalType.DATE)
    @Column(name = "DAT_NAISS_PP")
    private Date DAT_NAISS_PP;

    @Size(min = 2, max = 2)
    @Column(name = "PAYS_ISO")
    private String PAYS_ISO;

    @Size(min = 2, max = 1)
    @Column(name = "SEXE_PP")
    private String SEXE_PP;

    @Size(min = 2, max = 60)
    @Column(name = "ADRES")
    private String ADRES;

    @Size(min = 2, max = 30)
    @Column(name = "EMAIL")
    private String EMAIL;

    @Size(min = 2, max = 60)
    @Column(name = "NOM_PP_CONTACT")
    private String NOM_PP_CONTACT;

    @Size(min = 2, max = 60)
    @Column(name = "PREN_PP_CONTACT")
    private String PREN_PP_CONTACT;

    @Size(min = 2, max = 60)
    @Column(name = "ADRES_TEL_CONTACT")
    private String ADRES_TEL_CONTACT;

    @Size(min = 2, max = 60)
    @Column(name = "EMAIL_PP_CONTACT")
    private String EMAIL_PP_CONTACT;

    @Size(min = 2, max = 6)
    @Column(name = "CODE_ACTIV_PM")
    private String CODE_ACTIV_PM;

    @Size(min = 2, max = 50)
    @Column(name = "IDENTIFIANT")
    private String IDENTIFIANT;

    @Size(min = 2, max = 2)
    @Column(name = "PAYS_ISO_ADRES")
    private String PAYS_ISO_ADRES;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OUV_CPTE")
    private Date DATE_OUV_CPTE;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CLOT_CPTE")
    private Date DATE_CLOT_CPTE;

    @Size(min = 2, max = 15)
    @Column(name = "NUM_CRISQ")
    private String NUM_CRISQ;

    @Size(min = 2, max = 2)
    @Column(name = "CLE_RIB_CPTE")
    private String CLE_RIB_CPTE;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_MOD_CPTE")
    private Date DATE_MOD_CPTE;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_DECL_CPTE")
    private Date DATE_DECL_CPTE;

    @Size(min = 2, max = 1)
    @Column(name = "TRF_BCEAO")
    private String TRF_BCEAO;

    @Size(min = 2, max = 22)
    @Column(name = "RIB_CPTE")
    private String RIB_CPTE;

    @Size(min = 2, max = 60)
    @Column(name = "VILLE_RESID")
    private String VILLE_RESID;

    @Size(min = 2, max = 60)
    @Column(name = "PIECE_IDNUM")
    private String PIECE_IDNUM;

    @Size(min = 2, max = 1)
    @Column(name = "CATEG_PM")
    private String CATEG_PM;

    @Size(min = 2, max = 60)
    @Column(name = "RAIS_SOC_PM")
    private String RAIS_SOC_PM;

    @Size(min = 2, max = 60)
    @Column(name = "SIGLE_PM")
    private String SIGLE_PM;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREAT_PM")
    private Date DATE_CREAT_PM;

    @Size(min = 2, max = 6)
    @Column(name = "GESTION_CODE")
    private String GESTION_CODE;

}