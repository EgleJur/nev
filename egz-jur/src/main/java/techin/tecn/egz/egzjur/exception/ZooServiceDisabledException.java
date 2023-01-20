package techin.tecn.egz.egzjur.exception;

//Galima naudoti anotacijas tiesiog Exception lygmeni, jeigu nenorime tureti centralizuotos logikos
//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Actor Not Found")
public class ZooServiceDisabledException extends RuntimeException {


    public ZooServiceDisabledException() {
    }

    public ZooServiceDisabledException(String message) {
        super(message);
    }

}
