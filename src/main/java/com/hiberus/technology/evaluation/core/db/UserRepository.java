package com.hiberus.technology.evaluation.core.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hiberus.technology.evaluation.core.db.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
    
    UserEntity findByEmail(String email);
}

