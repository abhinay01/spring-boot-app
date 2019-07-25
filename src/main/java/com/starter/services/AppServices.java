package com.starter.services;

import com.starter.entity.Employee;

public interface AppServices {
	
	Iterable<Employee> listDetails();
	
	Employee getDetailById(Integer employee_id);
	
	Employee saveDetails(Employee employee);
	
	void deleteRecord(Integer id);

}
