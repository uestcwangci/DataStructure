package javastructure.unit1;

public class Plural3_2 {
    private double real;
    private double imag;

    public Plural3_2() {
        this.real = 0;
        this.imag = 0;
    }

    public Plural3_2(double real) {
        this.real = real;
        this.imag = 0;
    }

    public Plural3_2(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return real + " + " + imag + "i";
    }
}
