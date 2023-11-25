package exception;

public abstract class PassWithTermException extends Exception {
    public PassWithTermException() {

    }

    public abstract int calculateTermOfOverdue();
}
