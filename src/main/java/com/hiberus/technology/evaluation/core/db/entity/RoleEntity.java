package com.hiberus.technology.evaluation.core.db.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class RoleEntity implements Serializable {

    @Setter @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_rol;

    @Setter @Getter
    private String name;
    
    @Setter @Getter
    private String description;
    
    @Setter @Getter
    @OneToMany(mappedBy = "rol")
    private List<UserEntity> users;

}
