package com.hbut.leeray.repository;

import com.hbut.leeray.entity.Ban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanRepository extends JpaRepository<Ban,Integer> {

}
