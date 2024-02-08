package timesheet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.demo.dto.AttachToManagerDTO;
import timesheet.demo.dto.CreateEmployeeDTO;
import timesheet.demo.dto.UpdateEmployeeDTO;
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
        User update = userRepository.findById(id).orElse(null);
        if (update != null) {
            update.setManagerBy(dto.getManagerId());

            userRepository.save(update);

            User updateManager = userRepository.findById(dto.getManagerId()).orElse(null);
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
        User update = userRepository.findById(id).orElse(null);
        if (update != null) {
            update.setName(dto.getName());
            update.setSex(dto.getSex());
            update.setImage(dto.getImage());
            update.setDepartment(dto.getDepartment());
            update.setCompany(dto.getCompany());

            userRepository.save(update);
        }
    }

}
