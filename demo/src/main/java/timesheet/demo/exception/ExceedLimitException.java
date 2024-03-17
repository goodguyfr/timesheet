package timesheet.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceedLimitException extends GeneralException {
    private int maxHour;

    public ExceedLimitException(Object errorClass, int maxHour) {
        this.setErrorCode(400);
        this.setErrorMessage("EXCEED_LIMIT");
        this.setErrorClass(errorClass);
        this.setMaxHour(maxHour);
    }
}
