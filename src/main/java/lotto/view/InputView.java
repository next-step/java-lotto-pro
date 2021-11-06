package lotto.view;

import lotto.exception.InvalidInputException;
import lotto.model.WinningNumbers;
import lotto.view.strategy.Input;
import lotto.view.strategy.InputPurchaseAmount;
import lotto.view.strategy.InputWinNumbers;

public class InputView {

    /**
     * 로또 구매금액을 입력합니다.
     *
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
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

}
