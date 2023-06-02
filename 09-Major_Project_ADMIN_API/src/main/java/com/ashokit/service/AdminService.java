package com.ashokit.service;

import com.ashokit.entity.binding.CaseWorkerForm;
import com.ashokit.entity.binding.PlanForm;

public interface AdminService {

	public String saveEmployee(CaseWorkerForm form);
	

	public String savePlan (PlanForm form);
}
