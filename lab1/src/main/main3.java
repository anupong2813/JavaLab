package lab1;

import java.util.Scanner;

public class main3 {

    public static void main(String[] args){
        int a, b, c;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        a = scan.nextInt();
        b = scan.nextInt();

        c = a + b;

        System.out.println("The sum of the two numbers is: " + c);
        scan.close();
    }
}

