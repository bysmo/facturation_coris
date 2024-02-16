package com.coris.facturation.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Embeddable
@Data
public class TarificationPK implements Serializable {

    @NotNull
    @Column(name = "activ_id")
    private Integer activ_id;

    @NotNull
    @Size(min = 2, max = 255)
    @Column(name = "supp_code")
    private String supp_code;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "tarif_code")
    private String tarif_code;

}
