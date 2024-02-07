package timesheet.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import timesheet.demo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
