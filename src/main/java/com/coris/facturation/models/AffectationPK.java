package com.coris.facturation.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class AffectationPK implements Serializable {

    @NotNull
    @Column(name = "Real_id")
    private Long Real_id;

    @NotNull
    @Column(name = "Filiale_id")
    private Integer Filiale_id;

}