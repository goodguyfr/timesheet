package timesheet.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("employee")

public class Employee {
    @Id
    private String id;
    private String name;
    private String sex;
    private String image;
    private String manager;
    private String department;
    private String company;
    private String salaryPerHour;
}
