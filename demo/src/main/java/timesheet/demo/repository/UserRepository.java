package timesheet.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import timesheet.demo.model.User;
import timesheet.demo.modelenum.UserEnum;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByIdAndQuitJob(String id, boolean deleted);

    List<User> findAllByRoleAndQuitJob(UserEnum userEnum, boolean deleted);
}
