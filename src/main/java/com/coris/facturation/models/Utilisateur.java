
package com.coris.facturation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
@EqualsAndHashCode(callSuper = false)
public class Utilisateur extends Horodatable {

    public Utilisateur() {
    }

    @Id
    @Column(name = "user_id")
    private Long user_id;

    @Size(min = 2, max = 255)
    @Column(name = "matricule")
    private String matricule;

    @Size(min = 2, max = 200)
    @Column(name = "user_email")
    private String user_email;

    @Size(min = 2, max = 255)
    @Column(name = "user_password")
    private String user_password;

    @Size(min = 2, max = 1)
    @Column(name = "user_active")
    private String user_active;

    @Size(min = 2, max = 1)
    @Column(name = "user_locked")
    private String user_locked;

    @Column(name = "user_failed_tries")
    private Integer user_failed_tries;

    @Temporal(TemporalType.DATE)
    @Column(name = "user_last_login_time")
    private Date user_last_login_time;

    @Column(name = "password_time_to_live")
    private Integer password_time_to_live;

    @Temporal(TemporalType.DATE)
    @Column(name = "password_set_time")
    private Date password_set_time;

    @Size(min = 2, max = 1)
    @Column(name = "has_first_logged")
    private String has_first_logged;

    @Temporal(TemporalType.DATE)
    @Column(name = "user_locked_time")
    private Date user_locked_time;

    @Size(min = 2, max = 50)
    @Column(name = "login_confirmation_token")
    private String login_confirmation_token;

    @Temporal(TemporalType.DATE)
    @Column(name = "login_token_set_time")
    private Date login_token_set_time;

    @Temporal(TemporalType.DATE)
    @Column(name = "login_token_confirmation_time")
    private Date login_token_confirmation_time;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "utilisateur_roles", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
    private List<Role> roles = new ArrayList<>();

}