package timesheet.demo.dto;

import lombok.Data;
import timesheet.demo.modelenum.DepartmentEnum;
import timesheet.demo.modelenum.UserEnum;


@Data
public class CreateEmployeeDTO {
    private String name;
    private String sex;
    private String image;
    private String managerBy;
    private DepartmentEnum department;
    private String company;
    private String salaryPerHour;
    private UserEnum role;
}