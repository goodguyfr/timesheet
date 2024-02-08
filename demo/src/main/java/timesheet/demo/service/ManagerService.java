package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.dto.CreateManagerDTO;
import timesheet.demo.model.User;
import timesheet.demo.model.UserEnum;
import timesheet.demo.repository.UserRepository;

@Service
public class ManagerService {
    @Autowired
    UserRepository userRepository;

    public void createManager(CreateManagerDTO dto) {
        User manager = new User();
        manager.setName(dto.getName());
        manager.setSex(dto.getSex());
        manager.setImage(dto.getImage());
        manager.setDepartment(dto.getDepartment());
        manager.setCompany(dto.getCompany());
        manager.setSalaryPerHour(dto.getSalaryPerHour());
        manager.setEmployeeIDs(dto.getEmployeeIDs());
        manager.setRole(UserEnum.MANAGER);

        userRepository.save(manager);
    }
}
