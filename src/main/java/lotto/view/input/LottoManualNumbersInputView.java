package lotto.view.input;

import java.util.List;

import utils.InputHandler;

public class LottoManualNumbersInputView {
	private static final String BUYING_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String BUYING_MANUAL_LOTTO_PROMPT = "수동으로 구매할 번호를 입력해 주세요.";

	private final InputHandler inputHandler;

	public LottoManualNumbersInputView(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}

	public List<List<Integer>> getManualLottoNumbers() {
		int buyingManualLottoCount = inputHandler.inputPositiveInteger(BUYING_MANUAL_LOTTO_COUNT);

		return inputHandler.inputPositiveIntegerListMany(BUYING_MANUAL_LOTTO_PROMPT, buyingManualLottoCount);
	}
}
