package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.RandomGenerateStrategy;
import lotto.domain.RankResult;
import lotto.domain.Ranks;
import lotto.domain.WinningLottoTicket;
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

			RankResult rankResult = rankResults(lottoTickets, winningLottoTicket);
			printRankResults(rankResult, inputMoney);
		} catch (RuntimeException e) {
			resultView.printErrorMessage(e.getMessage());
		}
	}

	private RankResult rankResults(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
		Ranks ranks = lottoTickets.ranks(winningLottoTicket);
		return ranks.rankResults();
	}

	private void printRankResults(RankResult rankResult, Money inputMoney) {
		resultView.printResult(rankResult, inputMoney);
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
