package timesheet.demo.dto;

import lombok.Data;
import timesheet.demo.modelenum.DepartmentEnum;
import timesheet.demo.modelenum.UserEnum;

import java.util.Set;

@Data
public class CreateManagerDTO {
    private String name;
    private String sex;
    private String image;
    private DepartmentEnum department;
    private String company;
    private String salaryPerHour;
    private Set<String> employeeIDs;
    private UserEnum role;
//    private DepartmentEnum crew;

}