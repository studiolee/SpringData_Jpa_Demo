package com.hbut.leeray.repository;

import com.hbut.leeray.entity.StuInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuInfoRepository extends JpaRepository<StuInfo, Integer> {
}
