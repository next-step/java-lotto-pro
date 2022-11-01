package lotto.view.input;

import utils.InputHandler;

public class LottoBonusNumberInputView {
	private static final String BONUS_NUMBER_PROMPT = "보너스 볼을 입력해 주세요.";

	private final InputHandler inputHandler;

	public LottoBonusNumberInputView(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}

	public int getBonusNumber() {
		return inputHandler.inputPositiveInteger(BONUS_NUMBER_PROMPT);
	}

}
