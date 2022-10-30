package lotto.controller;

import java.util.stream.Collectors;

import lotto.controller.dto.LottoWinResultsRequest;
import lotto.controller.dto.LottoWinResultsResponse;
import lotto.controller.dto.PurchasedLottoTicketsResponse;
import lotto.controller.dto.WinningLottoTicketResponse;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoVendor;
import lotto.domain.LottoWinPrizes;
import money.Money;
import utils.InputHandler;
import utils.SplitStrings;
import utils.StringSplitter;

public class LottoController {

	private final LottoVendor lottoVendor;
	private final Money lottoPrice;

	public LottoController(Money lottoPrice, LottoVendor lottoVendor) {
		this.lottoPrice = lottoPrice;
		this.lottoVendor = lottoVendor;
	}

	public PurchasedLottoTicketsResponse quickPick(Money inputMoneyToPurchase) {
		return PurchasedLottoTicketsResponse.of(lottoVendor.quickPick(inputMoneyToPurchase));
	}

	public WinningLottoTicketResponse getLottoTicket() {
		String input = InputHandler.input();
		SplitStrings splitStrings = StringSplitter.split(input);

		return WinningLottoTicketResponse.of(
			splitStrings.stream()
				.map(Integer::valueOf)
				.collect(Collectors.toList()));
	}

	public LottoWinResultsResponse getWinResults(LottoWinResultsRequest request) {
		LottoTickets purchaseLottoTickets = request.getPurchasedLottoTickets();
		LottoTicket winningLottoTicket = request.getWinningLottoTicket();
		LottoWinPrizes lottoWinPrizes = purchaseLottoTickets.match(winningLottoTicket,
			request.getBonusLottoNumber());

		return LottoWinResultsResponse.of(lottoWinPrizes, lottoPrice);
	}
}
