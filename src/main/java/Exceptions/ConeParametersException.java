package Exceptions;

public class ConeParametersException extends Exception {
    private String coneParametersMessage;

    public ConeParametersException(String coneParametersMessage){
        this.coneParametersMessage = coneParametersMessage;
    }

    @Override
    public String toString() {
        return "ConeParametersException{" +
                "coneParametersMessage='" + coneParametersMessage + '\'' +
                '}';
    }
}
