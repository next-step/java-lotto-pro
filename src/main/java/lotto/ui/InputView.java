package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("The purchase price should contain only numbers.");
        }

        return purchasePrice;
    }

    public static String getWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String result = SCANNER.nextLine();
        return result;
    }

    public static int getBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        int bonusBallNumber;
        try {
            bonusBallNumber = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("Bonus ball number should be a number.");
        }

        return bonusBallNumber;
    }
}
