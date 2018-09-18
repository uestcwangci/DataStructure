package javastructure.unit2;

public class PolyData {
    public double coe;
    public int pow;

    public PolyData() {
        this(0.0, 0);
    }

    public PolyData(double coe, int pow) {
        this.coe = coe;
        this.pow = pow;
    }

    @Override
    public String toString() {
        return "系数：" + this.coe + "\t级数:" + this.pow;
    }
}
