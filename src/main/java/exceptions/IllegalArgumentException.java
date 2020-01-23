package Exceptions;

public class IllegalArgumentException extends Exception {

    private  String illegalArgumentMessage;

    public IllegalArgumentException(String illegalArgumentMessage){
        this.illegalArgumentMessage = illegalArgumentMessage;
    }

    @Override
    public String toString() {
        return "IllegalArgumentException{" +
                "illegalArgumentMessage='" + illegalArgumentMessage + '\'' +
                '}';
    }
}
