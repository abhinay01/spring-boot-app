package com.starter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.entity.Employee;
import com.starter.repository.AppRepository;

@Service
public class AppServiceImplementation implements AppServices {
	
	private AppRepository apprepository;
	
	@Autowired
	public void setApprepository(AppRepository apprepository) {
		this.apprepository = apprepository;
	}

	@Override
	public Iterable<Employee> listDetails() {
		
		return apprepository.findAll();
	}

	@Override
	public Employee getDetailById(Integer employee_id) {
		return apprepository.findOne(employee_id);
	}

	@Override
	public Employee saveDetails(Employee employee) {
		return apprepository.save(employee);
	}

	@Override
	public void deleteRecord(Integer employee_id) {
		apprepository.delete(employee_id);
	}

	

}

