package timesheet.demo.model;

import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
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
    private String department;
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
