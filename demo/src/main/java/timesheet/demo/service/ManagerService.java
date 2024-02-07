package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.repository.UserRepository;

@Service
public class ManagerService {
    @Autowired
    UserRepository personnelRepository;


}
