public class Calculation {

    private double op1;
    private double op2;
    private String operatorString;

    public Calculation(double op1, double op2, String operatorString) {
        this.op1 = op1;
        this.op2 = op2;
        this.operatorString = operatorString;
    }

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }

    public String getOperatorString() {
        return operatorString;
    }

    public void setOperatorString(String operatorString) {
        this.operatorString = operatorString;
    }
}
