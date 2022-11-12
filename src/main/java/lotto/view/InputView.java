package lotto.view;

import lotto.model.dto.PurchaseAmount;
import utils.InputConsole;

public class InputView {

    /**
     * 로또 구입금액 입력
     *
     * @return 사용자 입력값
     */
    public PurchaseAmount purchaseAmountInput() {
        String input = InputConsole.inputLine("구입금액을 입력해 주세요.");
        return new PurchaseAmount(input);
    }

    /**
     * 수동 로또 구입 개수 입력
     *
     * @return 사용자 입력값
     */
    public String manualLottoCountInput() {
        return InputConsole.inputLine("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    /**
     * 수동 로또 구입 번 입력
     *
     * @return 사용자 입력값
     */
    public String[] manualLottoNumbersInput(long count) {
        return InputConsole.inputLines("수동으로 구매할 번호를 입력해 주세요.", count);
    }

    /**
     * 지난주 당첨번호 입력
     *
     * @return 사용자 입력값
     */
    public String winLottoInput() {
        return InputConsole.inputLine("지난 주 당첨 번호를 입력해 주세요.");
    }

    /**
     * 지난주 당첨 보너스볼 입력
     *
     * @return 사용자 입력값
     */
    public String bonusBallInput() {
        return InputConsole.inputLine("보너스 볼을 입력해 주세요.");
    }
}
