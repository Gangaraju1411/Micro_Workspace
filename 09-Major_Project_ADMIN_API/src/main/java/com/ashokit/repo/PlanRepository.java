package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CreatePlanEntity;

public interface PlanRepository extends JpaRepository<CreatePlanEntity,Integer>{

}
