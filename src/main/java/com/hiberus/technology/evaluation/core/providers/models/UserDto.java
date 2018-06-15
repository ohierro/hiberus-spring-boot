package com.hiberus.technology.evaluation.core.providers.models;

import lombok.Data;

@Data
public class UserDto {
    
    public Integer id_user;
    public String name;
    public String surname;
    public String nif;
    public String email;
}
