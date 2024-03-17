package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.dto.CreateManagerDTO;
import timesheet.demo.dto.DeleteEmployeeDTO;
import timesheet.demo.dto.DeleteManagerDTO;
import timesheet.demo.exception.ResourceNotFoundException;
import timesheet.demo.model.User;
import timesheet.demo.modelenum.UserEnum;
import timesheet.demo.repository.UserRepository;

import java.util.*;

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
        User employee = userRepository.findByIdAndQuitJob(id, false)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
        if (employee != null && employee.getRole().equals(UserEnum.EMPLOYEE)) {
            employee.setQuitJob(true);
            employee.setDateQuitJob(new Date());
            employee.setReasonQuitJob(dto.getReasonQuitJob());

            userRepository.save(employee);
        }
    }

    public void deleteManager(String id, DeleteManagerDTO dto) {
        User manager = userRepository.findByIdAndQuitJob(id, false)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
        if (manager.getRole().equals(UserEnum.MANAGER)) {
            if (manager.getEmployeeIDs() != null) {
                User newManager = new User();
                if (dto.getNewManagerId() != null) {
                    newManager = userRepository.findByIdAndQuitJob(dto.getNewManagerId(), false)
                            .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
                } else {
                    // Manager has employees --> random manager to management employyes
                    List<String> userIds = userRepository.findAllByRoleAndQuitJob(manager.getRole(), false)
                            .stream().map(User::getId).filter(itId -> !itId.equals(id)).toList();
                    Random random = new Random();
//                   int randomId =random.nextInt(userIds.size());
//                   String newId = userIds.get(randomId);
                    String newId = userIds.get(random.nextInt(userIds.size()));
                    newManager = userRepository.findById(newId)
                            .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
                }
                // Manager has employees --> pick another manager to management employees
                if (newManager.getEmployeeIDs() == null) {
                    newManager.setEmployeeIDs(new HashSet<>());
                }
                newManager.getEmployeeIDs().addAll(manager.getEmployeeIDs());

                userRepository.save(newManager);
            }
            // Manager hasn't employees
            manager.setQuitJob(true);
            manager.setDateQuitJob(new Date());
            manager.setReasonQuitJob(dto.getReasonQuitJob());
            manager.setEmployeeIDs(new HashSet<>());

            userRepository.save(manager);
        }
    }

//    public List<User> findManager() {
//       return userRepository.findAllByRoleAndQuitJob(UserEnum.MANAGER, false);
//    }

}
