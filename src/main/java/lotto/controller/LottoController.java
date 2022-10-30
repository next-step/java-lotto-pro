package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import lotto.controller.dto.LottoWinResultsRequest;
import lotto.controller.dto.LottoWinResultsResponse;
import lotto.controller.dto.PurchasedLottoTicketsResponse;
import lotto.controller.dto.WinningLottoTicketResponse;
import lotto.domain.AutoLottoTicketsVendor;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinPrizes;
import money.Money;
import utils.InputHandler;
import utils.SplitStrings;
import utils.StringSplitter;

public class LottoController {

	private final AutoLottoTicketsVendor autoLottoTicketsVendor;
	private final Money lottoPrice;

	public LottoController(Money lottoPrice, AutoLottoTicketsVendor autoLottoTicketsVendor) {
		this.lottoPrice = lottoPrice;
		this.autoLottoTicketsVendor = autoLottoTicketsVendor;
	}

	private LottoTickets buyManualLottoTickets(List<List<Integer>> manualLottoNumbers) {
		return LottoTickets.ofList(manualLottoNumbers);
	}

	public PurchasedLottoTicketsResponse quickPick(Money inputMoneyToPurchase) {
		int buyingAutoLottoTicketsCount = getBuyingAutoLottoTicketsCounts(inputMoneyToPurchase);

		return PurchasedLottoTicketsResponse.of(
			autoLottoTicketsVendor.buyAutoLottoTickets(buyingAutoLottoTicketsCount));
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

	private int getBuyingAutoLottoTicketsCounts(Money buyingAutoLottoTicketsMoney) {
		BigDecimal buyingAutoLottoTicketsCounts = buyingAutoLottoTicketsMoney.divideBy(lottoPrice);
		return buyingAutoLottoTicketsCounts.intValue();
	}
}
