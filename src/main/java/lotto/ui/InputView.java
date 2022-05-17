package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public static int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        int purchasePrice;
        try {
            purchasePrice = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("The purchase price should contain only numbers.");
        }

        return purchasePrice;
    }

    public static String getWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
