package timesheet.demo.dto;

import lombok.Data;
import timesheet.demo.model.UserEnum;


@Data
public class CreateEmployeeDTO {
    private String name;
    private String sex;
    private String image;
    private String managerBy;
    private String department;
    private String company;
    private String salaryPerHour;
    private UserEnum role;
}