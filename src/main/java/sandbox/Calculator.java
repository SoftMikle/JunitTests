package sandbox;

public class Calculator {
    private int arg1;
    private int arg2;

    public Calculator(int arg1, int arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public int getSummation(){
        int tmp = getArg1() + getArg2();
        return tmp;
    }

    public int getDiff(){
        int tmp = getArg1() - getArg2();
        return tmp;
    }


    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public int getArg2() {
        return arg2;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }
}
