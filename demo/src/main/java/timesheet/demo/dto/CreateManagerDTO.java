package timesheet.demo.dto;

import lombok.Data;
import timesheet.demo.model.UserEnum;

import java.util.Set;

@Data
public class CreateManagerDTO {
    private String name;
    private String sex;
    private String image;
    private String department;
    private String company;
    private String salaryPerHour;
    private Set<String> employeeIDs;
    private UserEnum role;
}
