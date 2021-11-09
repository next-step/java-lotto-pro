package lotto.view;

import lotto.exception.InvalidInputException;
import lotto.model.BonusNumber;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;
import lotto.view.strategy.Input;
import lotto.view.strategy.InputBonusNumber;
import lotto.view.strategy.InputPurchaseAmount;
import lotto.view.strategy.InputWinNumbers;

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
     * 로또 당첨번호를 입력합니다.
     *
     * @return 로또 당첨번호
     */
    public static WinningNumbers inputWinningNumbers() {
        try {
            Input input = new InputWinNumbers();
            String value = input.getValue();
            return new WinningNumbers(value);
        } catch (InvalidInputException | NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    /**
     * 로또 보너스번호를 입력합니다.
     *
     * @return
     */
    public static WinningNumber inputBonusNumber(WinningNumbers winningNumbers) {
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
