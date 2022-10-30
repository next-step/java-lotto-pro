package lotto.view;

import lotto.domain.LottoMoney;

import java.util.Scanner;

public class InputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String ENTER_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static int getLottoPurchasePrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("입력한 값이 올바르지 않아 로또 구매에 실패했습니다.");
        }
        return purchasePrice;
    }

    public static LottoMoney getLottoPurchasePrice1() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        try {
            return new LottoMoney(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoPurchasePrice1();
        }
    }

    public static String getLastWeekWinningNumber() {
        System.out.println(ENTER_LAST_WEEK_WINNING_NUMBER);
        return SCANNER.nextLine();
    }

    public static int getBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다.");
        }
        return bonusNumber;
    }

}
