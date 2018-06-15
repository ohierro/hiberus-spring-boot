package com.hiberus.technology.evaluation.core.providers.impl;

import com.hiberus.technology.evaluation.core.db.RoleRepository;
import com.hiberus.technology.evaluation.core.db.entity.RoleEntity;
import com.hiberus.technology.evaluation.core.providers.RoleProvider;
import com.hiberus.technology.evaluation.core.providers.models.RoleDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleProviderImpl implements RoleProvider {

    @NonNull
    private RoleRepository roleRepository;

    @NonNull
    private ModelMapper modelMapper;

    @Override
    public List<RoleDto> findRoles() {
        return roleRepository.findAll()
                .stream()
                .map(v -> modelMapper.map(v, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto addRole(RoleDto dto) {
        RoleEntity entity = new RoleEntity();

        entity = modelMapper.map(dto, RoleEntity.class);
        entity = roleRepository.save(entity);

        return modelMapper.map(entity, RoleDto.class);
    }

    @Override
    public void editRole(RoleDto dto) {
        Optional<RoleEntity> result = roleRepository.findById(dto.getId());
//        if (!result.isPresent())
//            throw new Exception("Role not found");

        RoleEntity entity = modelMapper.map(dto, RoleEntity.class);
        roleRepository.save(entity);
    }

    @Override
    public RoleDto removeRole(RoleDto dto) {
        return null;
    }
}
