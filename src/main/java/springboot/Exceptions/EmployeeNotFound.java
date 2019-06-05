package springboot.Exceptions;

public class EmployeeNotFound extends RuntimeException {
	public EmployeeNotFound(long id) {
		super("this employee was not found "+ id +".");
	}
}
