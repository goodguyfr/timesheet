package timesheet.demo.dto;

import lombok.Data;

@Data
public class UpdateEmployeeDTO {
    private String name;
    private String sex;
    private String image;
    private String department;
    private String company;
}
