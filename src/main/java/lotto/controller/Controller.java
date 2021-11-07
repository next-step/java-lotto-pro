package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.domain.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Controller {
	private final InputView inputView;
	private final ResultView resultView;

	public Controller(final InputView inputView, final ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public void run() {
	}
}
