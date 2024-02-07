package timesheet.demo.model;

import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")

public class User {
    @Id
    private String id;
    private String name;
    private String sex;
    private String image;
    @Nullable
    private String managerBy;
    private String department;
    private String company;
    private String salaryPerHour;
    private UserEnum role;
}
