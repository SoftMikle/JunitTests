package Exceptions;

public class IllegalStateException extends Exception {
    private String illegalStateMessage;

    public IllegalStateException(String illegalStateMessage){
        this.illegalStateMessage = illegalStateMessage;
    }

    @Override
    public String toString() {
        return "IllegalStateException{" +
                "illegalStateMessage='" + illegalStateMessage + '\'' +
                '}';
    }
}
