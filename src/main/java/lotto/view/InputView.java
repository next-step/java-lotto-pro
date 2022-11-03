package lotto.view;

import lotto.domain.*;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_MANUAL_PURCHASE_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MESSAGE_MANUAL_NUMBERS_INFORMATION = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_LAST_WEEKS_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static LottoPurchaseAmount inputPurchaseAmount() {
        try {
            OutputView.println(INPUT_MESSAGE_PURCHASE_AMOUNT);
            return new LottoPurchaseAmount(Money.of(scanner.nextLine()));
        } catch (Exception e) {
            OutputView.error(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static LottoLotteryQuantity inputManualPurchaseQuantity(LottoPurchaseAmount lottoPurchaseAmount) {
        try {
            OutputView.printNewLine();
            OutputView.println(INPUT_MESSAGE_MANUAL_PURCHASE_QUANTITY);
            return LottoLotteryQuantity.of(lottoPurchaseAmount, LottoPurchaseQuantity.manualQuantity(scanner.nextLine()));
        } catch (Exception e) {
            OutputView.error(e.getMessage());
            return inputManualPurchaseQuantity(lottoPurchaseAmount);
        }
    }

    public static Optional<LottoLottery> inputManualNumbersInformation(LottoLotteryQuantity lottoLotteryQuantity) {
        try {
            OutputView.printNewLine();
            OutputView.println(INPUT_MESSAGE_MANUAL_NUMBERS_INFORMATION);
            return lottoLotteryQuantity.toManualLottoLottery();
        } catch (Exception e) {
            OutputView.error(e.getMessage());
            return inputManualNumbersInformation(lottoLotteryQuantity);
        }
    }

    public static String inputManualNumbers() {
        return scanner.nextLine();
    }

    public static LottoNumbers inputLastWeeksWinningNumber() {
        try {
            OutputView.printNewLine();
            OutputView.println(INPUT_MESSAGE_LAST_WEEKS_WINNING_NUMBER);
            return LottoNumbers.of(new ManualNumberGenerator(scanner.nextLine()));
        } catch (Exception e) {
            OutputView.error(e.getMessage());
            return inputLastWeeksWinningNumber();
        }
    }

    public static LottoNumber inputBonusNumber() {
        try {
            OutputView.println(INPUT_MESSAGE_BONUS_NUMBER);
            return LottoNumber.of(scanner.nextInt());
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_INPUT_ONLY_NUMBER);
        } catch (Exception e) {
            OutputView.error(e.getMessage());
            return inputBonusNumber();
        }
    }
}
