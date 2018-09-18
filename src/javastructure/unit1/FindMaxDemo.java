package javastructure.unit1;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class FindMaxDemo {
    public static Comparable findMax(Comparable[] a) {
        int k = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[k]) > 0) {
                k = i;
            }
        }
        return a[k];
    }

    public static void main(String[] args) {
//        Shape[] sh1 = new Shape[]{(Shape) new Circle(2.0), (Shape) new Rectangle(3.0, 4.0)};
        String[] sr1 = new String[]{"Bob", "Jany", "Kimi"};
//        System.out.println(findMax((Comparable[]) sh1));
        System.out.println(findMax(sr1));
    }
}
