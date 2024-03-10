package timesheet.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import timesheet.demo.model.UserSchedule;

@Repository
public interface ScheduleRepository extends MongoRepository<UserSchedule, String> {
}
