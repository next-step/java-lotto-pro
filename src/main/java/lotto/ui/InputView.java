package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() { }

    public static int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("The purchase price should contain only numbers.");
        }

    }

    public static String getWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int getBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("Bonus ball number should be a number.");
        }

    }

    public static List<String> getSelfTickets(int selfTicketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> selfTicketNumbers = new ArrayList<>();
        for (int i = 1; i <= selfTicketCount; i++) {
            selfTicketNumbers.add(SCANNER.nextLine());
        }

        return selfTicketNumbers;
    }

    public static int getSelfTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("The number of self lotto ticket should be a number.");
        }
    }
}
