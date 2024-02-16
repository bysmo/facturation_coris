package com.coris.facturation.models.CIP;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CIP_Input_CheckIrreg ")
public class CIP_Input_ChequeIrreg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DATA_ID")
    private Long DATA_ID;

}
