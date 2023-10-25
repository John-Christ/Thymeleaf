package com.howtodoinjava.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

//import binder for validation purpose
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class EmployeeMvcController
{

	@Autowired
	EmployeeService service;

	@RequestMapping
	public String getAllEmployees(Model model) 
	{
		List<EmployeeEntity> list = service.getAllEmployees();

		model.addAttribute("employees", list);
		return "list-employees";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmployeeById( Model model, @PathVariable("id") Optional<Long> id)
							throws RecordNotFoundException
	{
		if (id.isPresent()) {
			EmployeeEntity entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new EmployeeEntity());
		}
		return "add-edit-employee";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmployeeById(id);
		return "redirect:/";
	}



	@RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee( @Valid EmployeeEntity employee , BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "add-edit-employee";
		}

		service.createOrUpdateEmployee(employee);
		return "redirect:/list-employees";

	}

/*

	@PostMapping("/")
	public String checkEmployeeInfo (@Valid EmployeeEntity employee, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "add-edit-employee";
		}

		service.createOrUpdateEmployee(employee);
		return "redirect:/list-employees";
	}


*/



	@RequestMapping(path = {"/display", "/display/{id}"})
	public String displayEmployeeById(Model model, @PathVariable("id") Optional<Long> id)
			throws RecordNotFoundException
	{
		if (id.isPresent()) {
			EmployeeEntity entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		}
		return "display-employee";
	}


}


