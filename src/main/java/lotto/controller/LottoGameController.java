package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.domain.ManualGenerateStrategy;
import lotto.domain.Money;
import lotto.domain.RandomGenerateStrategy;
import lotto.domain.RankResult;
import lotto.domain.Ranks;
import lotto.domain.TicketCount;
import lotto.domain.WinningLottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

	private final InputView inputView;
	private final ResultView resultView;
	private final LottoTicketMachine lottoTicketMachine;

	private LottoGameController(InputView inputView, ResultView resultView, LottoTicketMachine lottoTicketMachine) {
		this.inputView = inputView;
		this.resultView = resultView;
		this.lottoTicketMachine = lottoTicketMachine;
	}

	public LottoGameController() {
		this(new InputView(), new ResultView(), LottoTicketMachine.create());
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
		TicketCount manualLottoCount = inputView.readManualLottoCount();
		Money manualLottoPrice = Money.from(LottoTicketMachine.LOTTO_COST_PER_TICKET * manualLottoCount.count());
		Money randomLottoPrice = money.subtract(manualLottoPrice);

		LottoTickets lottoTickets = purchasedLottoTickets(manualLottoPrice, randomLottoPrice);
		resultView.printLottoTickets(lottoTickets);
		return lottoTickets;
	}

	private WinningLottoTicket winningTicket() {
		LottoNumbers lottoNumbers = inputView.readWinningNumbers();
		LottoNumber bonusNumber = inputView.readBonusNumber();
		return WinningLottoTicket.from(lottoNumbers, bonusNumber);
	}

	private LottoTickets purchasedLottoTickets(Money manualLottoPrice, Money randomLottoPrice) {
		LottoTickets manualLottoTickets = manualLottoTickets(manualLottoPrice);
		LottoTickets randomLottoTickets = randomLottoTickets(randomLottoPrice);
		resultView.printLottoTicketsCount(manualLottoTickets.count(), randomLottoTickets.count());
		return manualLottoTickets.add(randomLottoTickets);
	}

	private LottoTickets randomLottoTickets(Money randomLottoPrice) {
		return lottoTicketMachine.lottoTickets(randomLottoPrice, new RandomGenerateStrategy());
	}

	private LottoTickets manualLottoTickets(Money manualLottoPrice) {
		resultView.printManualLottiTicketsMessage();
		return lottoTicketMachine.lottoTickets(manualLottoPrice, new ManualGenerateStrategy());
	}

}
