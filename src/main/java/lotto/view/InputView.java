package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner view = new Scanner(System.in);

    public static int inputBuyAmount(String buyAmountText) {
        System.out.println(buyAmountText);
        return view.nextInt();
    }
}
