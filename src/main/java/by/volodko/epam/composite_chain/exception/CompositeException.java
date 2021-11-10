package by.volodko.epam.composite_chain.exception;

public class CompositeException extends Exception {
    public CompositeException() {
        super();
    }

    public CompositeException(String message) {
        super(message);
    }

    public CompositeException(Exception e) {
        super(e);
    }

    public CompositeException(String message, Exception e) {
        super(message, e);
    }
}
