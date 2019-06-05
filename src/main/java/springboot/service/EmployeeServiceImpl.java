package springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.Exceptions.EmployeeNotFound;
import springboot.model.Employee;
import springboot.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeById(long id) throws EmployeeNotFound {
		return employeeRepository
				.findById(id)
				.orElseThrow(() -> new EmployeeNotFound(id));			
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
