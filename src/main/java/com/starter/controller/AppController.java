package com.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starter.entity.Employee;
import com.starter.services.AppServices;

@Controller
public class AppController {
	
	private AppServices appservice;

	@Autowired
	public void setAppservice(AppServices appservice) {
		this.appservice = appservice;
	}
	
	@RequestMapping("/addemployee")
	public String addDetails(Model model) {
		model.addAttribute("Employee", new Employee());
		return "regform";
	}
	
//	@RequestMapping("detail/new")
//	public String addDetails(Model model) {
//		model.addAttribute("Employee", new Employee());
//		return "regform";
//	}
//	
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("Employee", appservice.listDetails());
		System.out.println("53");
		return "employees";
	}
	
	

//	@RequestMapping(value="detail",method=RequestMethod.POST)
//	public String saveDetails(Employee employee) {
//		appservice.saveDetails(employee);
//		System.out.println("54");
//		return "products";
//	}
	
	@RequestMapping(value="detail",method=RequestMethod.POST)
	public String saveDetails(Employee employee) {
		appservice.saveDetails(employee);
		System.out.println("54");
		return "index";
	}
	
	
	@RequestMapping("/detail/{employee_id}")
	public String employee_Details(@PathVariable Integer employee_id,Model model) {
		model.addAttribute("Employee", appservice.getDetailById(employee_id));
		System.out.println("56");
		return "profile";
	}
	
	@RequestMapping("detail/edit/{employee_id}")
	public String editDetails(@PathVariable Integer employee_id,Model model) {
		model.addAttribute("Employee", appservice.getDetailById(employee_id));
		return "Update_prof";
	}
	
	@RequestMapping("detail/delete/{employee_id}")
	public String deleteDetails(@PathVariable Integer employee_id) {
		appservice.deleteRecord(employee_id);
		return "redirect:/details";
	}

}
