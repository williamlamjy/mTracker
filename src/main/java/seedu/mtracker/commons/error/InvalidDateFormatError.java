package seedu.mtracker.commons.error;

public class InvalidDateFormatError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_DATE_FORMAT_ERROR;
    }
}
