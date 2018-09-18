package javastructure.unit1;

public class PolyData {
    private double coe;
    private int pow;

    public double getCoe() {
        return coe;
    }

    public void setCoe(double coe) {
        this.coe = coe;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public PolyData(double coe, int pow) {

        this.coe = coe;
        this.pow = pow;
    }
}
