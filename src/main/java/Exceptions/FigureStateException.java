package Exceptions;

public class FigureStateException extends Exception {

    String figureStateMessage;

    public FigureStateException(String figureStateMessage) {
        this.figureStateMessage = figureStateMessage;
    }

    @Override
    public String toString() {
        return "FigureStateException{" +
                "figureStateMessage='" + figureStateMessage + '\'' +
                '}';
    }
}
