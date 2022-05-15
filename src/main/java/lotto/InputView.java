package lotto;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private String purchaseMoneyAmount;
    private String winningNumber;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void inputPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        this.purchaseMoneyAmount = scanner.nextLine();
    }

    public String getPurchaseMoneyAmount() {
        return purchaseMoneyAmount;
    }

    public void inputDrawingOfLots() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.winningNumber = scanner.nextLine();
        System.out.println();
    }

    public String getWinningNumber() {
        return winningNumber;
    }
}
