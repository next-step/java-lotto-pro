package lotto.view;

import lotto.model.domain.WinLotto;
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
     * 지난주 당첨번호 입력
     *
     * @return 사용자 입력값
     */
    public WinLotto winLottoInput() {
        String input = InputConsole.inputLine("지난 주 당첨 번호를 입력해 주세요.");
        return new WinLotto(input);
    }
}
