package springboot.service;

import java.util.List;

import springboot.Exceptions.EmployeeNotFound;
import springboot.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id) throws EmployeeNotFound;
}
