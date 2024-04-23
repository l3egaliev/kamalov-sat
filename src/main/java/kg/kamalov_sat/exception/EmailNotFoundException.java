package kg.kamalov_sat.exception;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String msg) {
        super(msg);
    }
}
