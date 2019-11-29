package com.chk.ubbprotool.repository;

import com.chk.ubbprotool.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//
@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
