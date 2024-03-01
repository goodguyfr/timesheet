package timesheet.demo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class DeleteManagerDTO {
    private String reasonQuitJob;
    private String newManagerId;
}