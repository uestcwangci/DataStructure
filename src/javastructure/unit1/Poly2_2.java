package javastructure.unit1;

import java.util.ArrayList;
import java.util.List;

public class Poly2_2 {
    public static void main(String[] args) {
        PolyData data1 = new PolyData(5.0, 0);
        PolyData data2 = new PolyData(3.5, 2);
        PolyData data3 = new PolyData(-7.8, 5);
        PolyData data4 = new PolyData(0.3, 6);
        PolyData data5 = new PolyData(-0.01, 10);
        List<PolyData> list = new ArrayList<>();
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        System.out.println(PolySum(list, 5));

    }

    private static double PolySum(List<PolyData> list, double x) {
        double result = 0;
        for (PolyData data : list) {
            result += data.getCoe() * Math.pow(x, data.getPow());
        }
        return result;
    }
}
