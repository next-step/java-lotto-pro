package lotto.view.input;

import utils.InputHandler;

public class LottoMoneyInputView {
	private static final String BUYING_MONEY_PROMPT = "구입금액을 입력해 주세요.";

	private final InputHandler inputHandler;

	public LottoMoneyInputView(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}

	public int getMoneyToBuyLotto() {
		return inputHandler.inputPositiveInteger(BUYING_MONEY_PROMPT);
	}

}
