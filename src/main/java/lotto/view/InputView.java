package lotto.view;

import lotto.domain.*;

import java.util.Scanner;

public class InputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String ENTER_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String REMAIN_MANUAL_LOTTO_COUNT = "[남은 수동 로또 입력 회수(%d/%d)]";
    private static final String ERROR_PREFIX = "[ERROR] %s";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static LottoMoney getLottoPurchasePrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return getLottoMoney();
    }

    private static LottoMoney getLottoMoney() {
        try {
            return new LottoMoney(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.printf((ERROR_PREFIX) + "%n", e.getMessage());
            return getLottoMoney();
        }
    }

    public static int getManualLottoCount(LottoMoney lottoMoney) {
        System.out.println();
        System.out.println(ENTER_MANUAL_LOTTO_COUNT);
        return manualPurchaseCount(lottoMoney);
    }

    private static int manualPurchaseCount(LottoMoney lottoMoney) {
        try {
            return lottoMoney.getValidLottoPurchaseCount(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.printf((ERROR_PREFIX) + "%n", e.getMessage());
            return manualPurchaseCount(lottoMoney);
        }
    }

    public static String getLastWeekWinningNumber() {
        System.out.println();
        System.out.println(ENTER_LAST_WEEK_WINNING_NUMBER);
        return SCANNER.nextLine();
    }

    public static int getBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        return getNumber();
    }

    private static int getNumber() {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return bonusNumber;
    }

    public static void manualLottoNumberScript() {
        System.out.println();
        System.out.println(ENTER_MANUAL_LOTTO_NUMBER);
    }

    public static LottoGenerator getManualLottoNumbers(int count, int total) {
        try {
            return new ManualLottoGenerator(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.printf((ERROR_PREFIX) + "%n", e.getMessage() + String.format(REMAIN_MANUAL_LOTTO_COUNT, count, total));
            return getManualLottoNumbers(count, total);
        }
    }

    public static WinningLottoNumbers getWinningNumbers() {
        try {
            String winningNumber = InputView.getLastWeekWinningNumber();
            LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
            return new WinningLottoNumbers(winningNumber, bonusNumber);
        } catch (Exception e) {
            System.out.printf((ERROR_PREFIX) + "%n", e.getMessage());
            return getWinningNumbers();
        }
    }

}
