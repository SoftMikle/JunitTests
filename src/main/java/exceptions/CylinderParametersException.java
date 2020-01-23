package Exceptions;

public class CylinderParametersException extends Exception {
    String cylinderParametersMessage;

    public CylinderParametersException(String cylinderParametersMessage) {
        this.cylinderParametersMessage = cylinderParametersMessage;
    }

    @Override
    public String toString() {
        return "CylinderParametersException{" +
                "cylinderParametersMessage='" + cylinderParametersMessage + '\'' +
                '}';
    }
}
