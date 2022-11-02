package lotto.view;

import lotto.domain.*;
import lotto.utils.LottoValidationUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String ENTER_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ERROR_PREFIX = "[ERROR] %s";
    private static final String COMMA = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static String getLottoPurchasePrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return getLottoMoney();
    }

    private static String getLottoMoney() {
        try {
            String lottoMoney = LottoValidationUtils.validLottoMoney(SCANNER.nextLine());
            return lottoMoney;
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
            return getManualLottoCount(lottoMoney);
        }
    }

    public static String getLastWeekWinningNumber() {
        System.out.println();
        System.out.println(ENTER_LAST_WEEK_WINNING_NUMBER);
        return SCANNER.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        return SCANNER.nextLine();
    }

    public static void manualLottoNumberScript() {
        System.out.println();
        System.out.println(ENTER_MANUAL_LOTTO_NUMBER);
    }

    public static String getManualLottoNumbers() {
        try {
            String lottoNumbers = SCANNER.nextLine();
            LottoValidationUtils.validLottoNumbers(lottoNumbers);
            return lottoNumbers;
        } catch (Exception e) {
            System.out.printf((ERROR_PREFIX) + "%n", e.getMessage());
            return getManualLottoNumbers();
        }
    }

    public static String[] getWinningNumbers() {
        try {
            String lastWeekWinningNumber = InputView.getLastWeekWinningNumber();
            LottoValidationUtils.validLottoNumbers(lastWeekWinningNumber);
            List<Integer> validWinningNumbers = Arrays
                    .asList(lastWeekWinningNumber.split(COMMA))
                    .stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            String bonusNumber = InputView.getBonusNumber();
            int validBonusNumber = LottoValidationUtils.validLottoNumber(bonusNumber);

            LottoValidationUtils.checkDuplicatedBonusNumber(validWinningNumbers, validBonusNumber);

            return new String[]{lastWeekWinningNumber, bonusNumber};
        } catch (Exception e) {
            System.out.printf((ERROR_PREFIX) + "%n", e.getMessage());
            return getWinningNumbers();
        }
    }

}
