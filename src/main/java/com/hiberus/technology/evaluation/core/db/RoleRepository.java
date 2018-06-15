package com.hiberus.technology.evaluation.core.db;

import com.hiberus.technology.evaluation.core.db.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
