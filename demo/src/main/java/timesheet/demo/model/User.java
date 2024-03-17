package timesheet.demo.model;

import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import timesheet.demo.modelenum.DepartmentEnum;
import timesheet.demo.modelenum.UserEnum;

import java.util.Date;
import java.util.Set;

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
    private DepartmentEnum department;
    private String company;
    private String salaryPerHour;
    @Nullable
    private Set<String> employeeIDs;
    private UserEnum role;
    @Nullable
    private boolean quitJob;
    @Nullable
    private Date dateQuitJob;
    @Nullable
    private String reasonQuitJob;
}
