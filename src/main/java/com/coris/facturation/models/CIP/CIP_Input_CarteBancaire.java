package com.coris.facturation.models.CIP;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CIP_Input_CarteBancaire ")

public class CIP_Input_CarteBancaire {

    public CIP_Input_CarteBancaire() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DATA_ID")
    private Long DATA_ID;

}