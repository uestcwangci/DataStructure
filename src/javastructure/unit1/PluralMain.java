package javastructure.unit1;

public class PluralMain implements PluralOperatin{
    public static void main(String[] args) {
        Plural3_2 data1 = new Plural3_2();
        Plural3_2 data2 = new Plural3_2(2.3);
        Plural3_2 data3 = new Plural3_2(-3.6, 4.1);
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        PluralMain m = new PluralMain();
        m.sum(data2, data3);
        m.sub(data2, data3);

    }


    @Override
    public void sum(Plural3_2 data1, Plural3_2 data2) {
        Plural3_2 result = new Plural3_2();
        result.setReal(data1.getReal() + data2.getReal());
        result.setImag(data1.getImag() + data2.getImag());
        System.out.println(result);
    }

    @Override
    public void sub(Plural3_2 data1, Plural3_2 data2) {
        Plural3_2 result = new Plural3_2();
        result.setReal(data1.getReal() - data2.getReal());
        result.setImag(data1.getImag() - data2.getImag());
        System.out.println(result);
    }
}
