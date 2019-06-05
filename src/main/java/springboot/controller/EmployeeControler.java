package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.Exceptions.EmployeeNotFound;
import springboot.model.Employee;

import springboot.service.EmployeeService;

@RestController
public class EmployeeControler {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value="/employee/{id}", method = RequestMethod.GET)
	@ExceptionHandler(EmployeeNotFound.class)
	public Employee getEmployee(@PathVariable("id") long id) throws EmployeeNotFound {	
		return employeeService.getEmployeeById(id);
	}
	
}
