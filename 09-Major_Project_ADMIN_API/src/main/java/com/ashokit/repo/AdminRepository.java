package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CaseWorkerEntity;


public interface AdminRepository extends JpaRepository<CaseWorkerEntity, Integer>{

}
