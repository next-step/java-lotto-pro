package lotto.view;

import lotto.exception.InvalidInputException;
import lotto.exception.UnexpectValueException;
import lotto.model.*;
import lotto.view.strategy.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public InputView() {
        throw new AssertionError();
    }

    /**
     * 로또 구매금액을 입력합니다.
     * <p>
     * return 로또 구매금액
     */
    public static int inputPurchaseAmount() {
        try {
            Input input = new InputPurchaseAmount();
            String value = input.getValue();
            return Integer.valueOf(value);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    /**
     * 로또 수동 구매수량을 입력합니다.
     *
     * @param gameCount
     * @return
     */
    public static ManualGameCount inputPurchaseManualGameCount(GameCount gameCount) {
        try {
            Input input = new InputPurchaseManualGameCount();
            String value = input.getValue();
            return new ManualGameCount(gameCount.getValue(), Integer.valueOf(value));
        } catch (InvalidInputException | UnexpectValueException e) {
            System.out.println(e.getMessage());
            return inputPurchaseManualGameCount(gameCount);
        }
    }

    /**
     * 로또 수동게임을 입력하여 생성합니다.
     *
     * @param manualGameCount
     * @return
     */
    public static ManualNumbers inputManualNumbers(int manualGameCount) {
        final int firstIndex = 0;
        List<LottoNumbers> list = IntStream.range(firstIndex, manualGameCount)
                .boxed()
                .map(operand -> inputManualGameNumbers(operand <= firstIndex))
                .collect(Collectors.toList());

        return new ManualNumbers(list);
    }

    /**
     * 로또 수동번호를 입력합니다.
     *
     * @param printTitleMessage
     * @return
     */
    private static LottoNumbers inputManualGameNumbers(boolean printTitleMessage) {
        try {
            Input input = new InputManualGameNumbers();
            String value = input.getValue(printTitleMessage);
            return new LottoNumbers(value);
        } catch (InvalidInputException | NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputManualGameNumbers(false);
        }
    }

    /**
     * 로또 당첨번호를 입력합니다.
     *
     * @return 로또 당첨번호
     */
    public static LottoNumbers inputWinningNumbers() {
        try {
            Input input = new InputWinNumbers();
            String value = input.getValue();
            return new LottoNumbers(value);
        } catch (InvalidInputException | NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    /**
     * 로또 보너스번호를 입력합니다.
     *
     * @param winningNumbers
     * @return
     */
    public static LottoNumber inputBonusNumber(LottoNumbers winningNumbers) {
        try {
            Input input = new InputBonusNumber();
            String value = input.getValue();
            return new BonusNumber(value, winningNumbers);
        } catch (InvalidInputException | NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

}
