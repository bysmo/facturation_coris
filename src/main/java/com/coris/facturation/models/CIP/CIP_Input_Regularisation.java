package com.coris.facturation.models.CIP;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CIP_Input_Regularisation ")
public class CIP_Input_Regularisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DATA_ID")
    private Long DATA_ID;

}
