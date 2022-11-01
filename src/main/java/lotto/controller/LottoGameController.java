package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.Ranks;
import lotto.domain.Result;
import lotto.domain.WinningLottoTicket;
import lotto.domain.strategy.RandomGenerateStrategy;
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

	public void play() {
		try {
			Money inputMoney = inputView.readMoney();

			LottoTickets lottoTickets = purchasedTickets(inputMoney);
			WinningLottoTicket winningLottoTicket = winningTicket();

			Result result = result(inputMoney, lottoTickets, winningLottoTicket);
			printResult(result);
		} catch (RuntimeException e) {
			resultView.printErrorMessage(e.getMessage());
		}
	}

	private Result result(Money inputMoney, LottoTickets lottoTickets,
		WinningLottoTicket winningLottoTicket) {
		Ranks ranks = Ranks.from(lottoTickets.ranks(winningLottoTicket));
		return Result.of(ranks, inputMoney);
	}

	private void printResult(Result result) {
		resultView.printResult(result);
	}

	private LottoTickets purchasedTickets(Money money) {
		LottoTickets lottoTickets = purchasedLottoTickets(money);
		resultView.printLottoTickets(lottoTickets);
		return lottoTickets;
	}

	private WinningLottoTicket winningTicket() {
		LottoNumbers lottoNumbers = inputView.readWinningNumbers();
		LottoNumber bonusNumber = inputView.readBonusNumber();
		return WinningLottoTicket.from(lottoNumbers, bonusNumber);
	}

	private LottoTickets purchasedLottoTickets(Money money) {
		LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(new RandomGenerateStrategy());
		return lottoTicketMachine.buyLottoTickets(money);
	}

}
