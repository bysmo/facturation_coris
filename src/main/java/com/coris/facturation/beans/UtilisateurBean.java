
package com.coris.facturation.beans;

import java.sql.Date;
import lombok.Data;

@Data
public class UtilisateurBean {

        private Long user_id;

        private String matricule;

        private String user_password;

        private String user_active;

        private String user_locked;

        private Integer user_failed_tries;

        private Date user_last_login_time;

        private Integer password_time_to_live;

        private Date password_set_time;

        private String has_first_logged;

        private Date user_locked_time;

        private String user_email;

        private String login_confirmation_token;

        private Date login_token_set_time;

        private Date login_token_confirmation_time;

        private Date date_creation;

        private Integer user_creation;

        private Date date_modification;

        private Integer user_modification;

        private Integer NIVEAU_ACCES;

}