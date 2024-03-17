package timesheet.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PayrollDTO {
    private List<Integer> estimatedWorkingTime;
    private Integer estimatedSalary;
    private List<Integer> actualWorkingTime;
    private Integer actualSalary;

}
