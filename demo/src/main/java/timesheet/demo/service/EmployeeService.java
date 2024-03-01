package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.dto.AttachToManagerDTO;
import timesheet.demo.dto.CreateEmployeeDTO;
import timesheet.demo.dto.UpdateEmployeeDTO;
import timesheet.demo.exception.ResourceNotFoundException;
import timesheet.demo.model.User;
import timesheet.demo.model.UserEnum;
import timesheet.demo.repository.UserRepository;

import java.util.HashSet;

@Service
public class EmployeeService {
    @Autowired
    UserRepository userRepository;

    public void createEmployee(CreateEmployeeDTO dto) {
        User employee = new User();
        employee.setName(dto.getName());
        employee.setSex(dto.getSex());
        employee.setImage(dto.getImage());
        employee.setManagerBy(dto.getManagerBy());
        employee.setDepartment(dto.getDepartment());
        employee.setCompany(dto.getCompany());
        employee.setSalaryPerHour(dto.getSalaryPerHour());
        employee.setRole(UserEnum.EMPLOYEE);

        userRepository.save(employee);
    }

    public void updateIdByManager(String id, AttachToManagerDTO dto) {
        User employee = userRepository.findByIdAndQuitJob(id, false)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
        if (employee != null) {
            employee.setManagerBy(dto.getManagerId());

            userRepository.save(employee);

            User updateManager = userRepository.findByIdAndQuitJob(dto.getManagerId(), false)
                    .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
            if (updateManager != null) {
                if (updateManager.getEmployeeIDs() == null) {
                    updateManager.setEmployeeIDs(new HashSet<>());
                }
                updateManager.getEmployeeIDs().add(id);

                userRepository.save(updateManager);
            }

        }
    }

    public void updateEmployee(UpdateEmployeeDTO dto, String id) {
        User employee = userRepository.findByIdAndQuitJob(id, false)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
        if (employee != null) {
            employee.setName(dto.getName());
            employee.setSex(dto.getSex());
            employee.setImage(dto.getImage());
            employee.setDepartment(dto.getDepartment());
            employee.setCompany(dto.getCompany());

            userRepository.save(employee);
        }
    }

}
