package com.hiberus.technology.evaluation.core.db.entity;


import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Setter @Getter
    @Column(name = "id")
    @Id
    @GeneratedValue()
    private Integer id_user;

    @Setter @Getter
    private String name;

    @Setter @Getter
    private String surname;
    
    @Setter @Getter
    private String passwd;

    @Setter @Getter
    private String nif;
    
    @Setter @Getter
    private String email;
    
    @Setter @Getter
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RoleEntity rol;
}
