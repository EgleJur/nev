package techin.tecn.egz.egzjur.exception;

//Galima naudoti anotacijas tiesiog Exception lygmeni, jeigu nenorime tureti centralizuotos logikos
//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Actor Not Found")
public class ZooValidationException extends RuntimeException {

    private String field;
    private String error;

    private String rejectedValue;

    public ZooValidationException() {
    }

    public ZooValidationException(String message, String field, String error, String rejectedValue) {
        super(message);
        this.field = field;
        this.error = error;
        this.rejectedValue = rejectedValue;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }
}
