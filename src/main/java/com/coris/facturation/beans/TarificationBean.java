
package com.coris.facturation.beans;

import lombok.Data;

@Data
public class TarificationBean {

        private Integer activ_id;

        private String supp_code;

        private String tarif_code;

        private Double MONTANT_TARIF;

        private Object date_creation;

        private Integer user_creation;

        private Object date_modification;

        private Integer user_modification;

        private Integer NIVEAU_ACCES;

}