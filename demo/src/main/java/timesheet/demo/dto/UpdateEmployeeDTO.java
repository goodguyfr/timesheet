package timesheet.demo.dto;

import lombok.Data;
import timesheet.demo.modelenum.DepartmentEnum;

@Data
public class UpdateEmployeeDTO {
    private String name;
    private String sex;
    private String image;
    private DepartmentEnum department;
    private String company;
}
