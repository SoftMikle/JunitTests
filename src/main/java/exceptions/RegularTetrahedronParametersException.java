package Exceptions;

public class RegularTetrahedronParametersException extends Exception {
    String regularTetrahedronMessage;

    public RegularTetrahedronParametersException(String regularTetrahedronMessage){
        this.regularTetrahedronMessage=regularTetrahedronMessage;
    }

    @Override
    public String toString() {
        return "RegularTetrahedronException{" +
                "regularTetrahedronMessage='" + regularTetrahedronMessage + '\'' +
                '}';
    }
}
