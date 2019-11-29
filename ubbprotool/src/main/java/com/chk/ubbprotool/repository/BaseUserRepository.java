package com.chk.ubbprotool.repository;

import com.chk.ubbprotool.model.BaseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUserEntity, Long> {
}
