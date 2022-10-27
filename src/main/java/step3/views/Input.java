package step3.views;

import java.util.Scanner;

public class Input {

    private final Scanner sc;

    public Input() {
        this.sc = new Scanner(System.in);
    }

    public int inputNumber() {
        return sc.nextInt();
    }

    public String inputString() {
        return sc.next();
    }

}
