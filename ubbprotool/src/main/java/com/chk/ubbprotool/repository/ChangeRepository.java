package com.chk.ubbprotool.repository;

import com.chk.ubbprotool.model.ChangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRepository extends JpaRepository<ChangeEntity, Long> {
}