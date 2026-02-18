package lab1;

import java.util.Scanner;
import java.lang.Math;

public class main4 {
    public static void main(String[] args) {
        int radius;
        double area;
        System.out.println("Enter the radius of the circle: ");
        Scanner scan = new Scanner(System.in);
        radius = scan.nextInt();
        area = Math.PI * radius * radius;
        System.out.println("Area of the circle is " + area);
        scan.close();
    }
}
