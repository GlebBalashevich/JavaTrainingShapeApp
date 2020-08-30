package by.balashevich.shapeapp.exception;

public class ShapeProjectException extends Exception{
    public ShapeProjectException() {
        super();
    }

    public ShapeProjectException(String message) {
        super(message);
    }

    public ShapeProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeProjectException(Throwable cause) {
        super(cause);
    }
}
