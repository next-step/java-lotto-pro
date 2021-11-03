package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {
	private final InputView inputView;

	public LottoController() {
		this.inputView = new InputView();
	}

	public void play() {
		Money money = inputView.inputMoney();
	}
}
