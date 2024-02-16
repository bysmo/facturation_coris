package com.coris.facturation.models.CIP;

import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CIP_Input_Incident ")
public class CIP_Input_Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DATA_ID")
    private Long DATA_ID;

}
