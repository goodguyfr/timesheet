package timesheet.demo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public abstract class GeneralException extends RuntimeException implements Serializable {
    private String errorMessage;
    private int errorCode = 500;
    private String errorField;
    private Object errorClass;
    @Override
    public String getMessage() {
        return
                String.format("[%s] with http status [%s],  field not found: [%s], by class: [%s]",
                        this.getErrorMessage(), this.getErrorCode(), this.getErrorField(), this.getErrorClass());
    }
}