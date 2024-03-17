package timesheet.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import timesheet.demo.model.UserSchedule;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends MongoRepository<UserSchedule, String> {
    //    Optional<UserSchedule> findByIdAndQuitJob(String id, boolean deleted);
    Optional<UserSchedule> findByUserId(String id);
}