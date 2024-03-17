package timesheet.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import timesheet.demo.dto.ScheduleDTO;

import java.util.List;

@Data
@Document("schedule")
public class UserSchedule {
    @Id
    private String id;
    private String userId;
    List<ScheduleDTO> plan;
}

//class ExampleDTO{
//    List<UserSchedule> month =new ArrayList<>();
//
//    if(dto.month.size>4){
//        throw
//    }
//
//    public List<UserSchedule> getMonth() {
//        .loops}{
//        item.size>5
//        {
//            throw
//        }
//    }
//}
