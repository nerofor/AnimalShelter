package uni.eszterhazy.animalshelter.exception;

public class InvalidDateOfBirth extends Throwable{
    public InvalidDateOfBirth(String dateOfBirth) {
        super(dateOfBirth);
    }
}
