package lotto.view.input;

import java.util.List;

import utils.InputHandler;

public class LottoWinNumberInputView {
	private static final String INPUT_PROMPT_OUTPUT = "지난 주 당첨 번호를 입력해 주세요.";

	private final InputHandler inputHandler;

	public LottoWinNumberInputView(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}

	public List<Integer> getWinLottoNumbers() {
		return inputHandler.inputPositiveIntegerList(INPUT_PROMPT_OUTPUT);
	}

}
