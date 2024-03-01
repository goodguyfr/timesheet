package timesheet.demo.exception;

public class ResourceNotFoundException extends GeneralException{
    public ResourceNotFoundException(Object errorClass, Object errorField) {
        this.setErrorCode(404);
        this.setErrorMessage("RESOURCE_NOT_FOUND");
        this.setErrorClass(errorClass);
        this.setErrorField(errorField.toString());
    }
}
