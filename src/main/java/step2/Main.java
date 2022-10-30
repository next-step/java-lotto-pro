package step2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        Number number = calculator.sum(sc.nextLine());
        System.out.println(number);
    }
}
