package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.dto.CreateManagerDTO;
import timesheet.demo.dto.DeleteEmployeeDTO;
import timesheet.demo.model.User;
import timesheet.demo.model.UserEnum;
import timesheet.demo.repository.UserRepository;

import java.time.ZonedDateTime;
import java.util.Date;

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

    public void deleteEmployee(String id, DeleteEmployeeDTO dto) {
        User deleteEmployye = userRepository.findById(id).orElse(null);
        if (deleteEmployye != null && deleteEmployye.getRole().equals(UserEnum.EMPLOYEE)) {
            deleteEmployye.setReasonQuitJob(dto.getReasonQuitJob());
            deleteEmployye.setDateQuitJob(new Date());
            deleteEmployye.setQuitJob(true);

            userRepository.save(deleteEmployye);
        }
    }
}
