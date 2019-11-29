package com.chk.ubbprotool.repository;

import com.chk.ubbprotool.model.SubgroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubgroupRepository extends JpaRepository<SubgroupEntity, Long> {
}
