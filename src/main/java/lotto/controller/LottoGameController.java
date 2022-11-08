package lotto.controller;

import java.util.List;

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
		this(new InputView(), new ResultView(), LottoTicketMachine.getInstance());
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
		if (manualLottoCount.isZero()) {
			return randomLottoTickets(money);
		}

		Money manualLottoPrice = manualLottoPrice(manualLottoCount);
		Money randomLottoPrice = randomLottoPrice(money, manualLottoPrice);

		LottoTickets lottoTickets = purchasedLottoTickets(manualLottoPrice, randomLottoPrice);
		resultView.printLottoTickets(lottoTickets);
		return lottoTickets;
	}

	private Money randomLottoPrice(Money money, Money manualLottoPrice) {
		return money.subtract(manualLottoPrice);
	}

	private Money manualLottoPrice(TicketCount manualLottoCount) {
		return Money.from(LottoTicketMachine.LOTTO_COST_PER_TICKET * manualLottoCount.count());
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
		List<LottoNumbers> randomLottoNumbersList = randomLottoNumbers(randomLottoPrice);
		return lottoTicketMachine.lottoTickets(randomLottoNumbersList);
	}

	private LottoTickets manualLottoTickets(Money manualLottoPrice) {
		List<LottoNumbers> manualLottoNumbers = manualLottoNumbers(manualLottoPrice);
		return lottoTicketMachine.lottoTickets(manualLottoNumbers);
	}

	private List<LottoNumbers> randomLottoNumbers(Money randomLottoPrice) {
		TicketCount randomTicketCount = lottoTicketMachine.ticketCount(randomLottoPrice);
		return randomTicketCount.map(i -> RandomGenerateStrategy.getInstance().generate());
	}

	private List<LottoNumbers> manualLottoNumbers(Money manualLottoPrice) {
		resultView.printManualLottiTicketsMessage();
		TicketCount ticketCount = lottoTicketMachine.ticketCount(manualLottoPrice);
		LottoNumbers lottoNumbers = InputView.readLottoNumbers();
		return ticketCount.map(i -> ManualGenerateStrategy.from(lottoNumbers).generate());
	}

}
