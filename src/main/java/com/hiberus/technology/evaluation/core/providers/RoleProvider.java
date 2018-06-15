package com.hiberus.technology.evaluation.core.providers;

import com.hiberus.technology.evaluation.core.providers.models.RoleDto;

import java.util.List;

public interface RoleProvider {
    public List<RoleDto> findRoles();
    RoleDto addRole(RoleDto dto);
    void editRole(RoleDto dto);
    RoleDto removeRole(RoleDto dto);
}
