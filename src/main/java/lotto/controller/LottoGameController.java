package lotto.controller;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

	private final InputView inputView;
	private final ResultView resultView;

	private LottoGameController(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public LottoGameController() {
		this(new InputView(), new ResultView());
	}

}
