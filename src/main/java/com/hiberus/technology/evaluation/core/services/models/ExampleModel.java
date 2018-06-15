package com.hiberus.technology.evaluation.core.services.models;

import lombok.Data;

import com.hiberus.technology.evaluation.core.db.entity.RoleEntity;

@Data(staticConstructor = "of")
public class ExampleModel {
    private final Integer id;
    private final String name;
    private final RoleEntity rol;
}
