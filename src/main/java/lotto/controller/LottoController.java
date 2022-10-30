package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import lotto.controller.dto.BoughtLottoTicketsResponse;
import lotto.controller.dto.LottoWinResultsRequest;
import lotto.controller.dto.LottoWinResultsResponse;
import lotto.controller.dto.WinningLottoTicketResponse;
import lotto.domain.AutoLottoTicketsVendor;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinPrizes;
import money.Money;
import utils.SplitStrings;
import utils.StringSplitter;

public class LottoController {

	private final AutoLottoTicketsVendor autoLottoTicketsVendor;
	private final Money lottoPrice;

	public LottoController(Money lottoPrice, AutoLottoTicketsVendor autoLottoTicketsVendor) {
		this.lottoPrice = lottoPrice;
		this.autoLottoTicketsVendor = autoLottoTicketsVendor;
	}

	public BoughtLottoTicketsResponse buyLottoTickets(int buyingLottoTicketsAmount,
													  List<List<Integer>> manualLottoNumbers) {
		return buyLottoTickets(Money.wons(buyingLottoTicketsAmount), manualLottoNumbers);
	}

	public BoughtLottoTicketsResponse buyLottoTickets(Money buyingLottoTicketsAmount,
													  List<List<Integer>> manualLottoNumbers) {
		int buyingAutoLottoTicketsCount = getBuyingAutoLottoTicketsCounts(buyingLottoTicketsAmount, manualLottoNumbers);

		LottoTickets manualLottoTickets = createManualLottoTickets(manualLottoNumbers);
		LottoTickets autoLottoTickets = buyAutoLottoTickets(buyingAutoLottoTicketsCount);

		return BoughtLottoTicketsResponse.of(manualLottoTickets, autoLottoTickets);
	}

	public WinningLottoTicketResponse getWinningLottoTicket(String winningLottoTicket) {
		SplitStrings splitStrings = StringSplitter.split(winningLottoTicket);

		return WinningLottoTicketResponse.of(
			splitStrings.stream()
				.map(Integer::valueOf)
				.collect(Collectors.toList()));
	}

	public LottoWinResultsResponse getWinResults(LottoWinResultsRequest request) {
		LottoTickets boughtLottoTickets = request.getBoughtLottoTickets();
		LottoTicket winningLottoTicket = request.getWinningLottoTicket();
		LottoWinPrizes lottoWinPrizes = boughtLottoTickets.match(winningLottoTicket,
			request.getBonusLottoNumber());

		return LottoWinResultsResponse.of(lottoWinPrizes, lottoPrice);
	}

	private LottoTickets createManualLottoTickets(List<List<Integer>> manualLottoNumbers) {
		return LottoTickets.ofList(manualLottoNumbers);
	}

	private LottoTickets buyAutoLottoTickets(int buyingAutoLottoTicketsCount) {
		return autoLottoTicketsVendor.buyAutoLottoTickets(buyingAutoLottoTicketsCount);
	}

	private int getBuyingAutoLottoTicketsCounts(Money buyingLottoTicketsAmount,
												List<List<Integer>> manualLottoNumbers) {
		int manualLottoCounts = manualLottoNumbers.size();
		Money buyingManualLottoTicketsAmount = lottoPrice.multiply(manualLottoCounts);
		Money buyingAutoLottoTicketsMoney = buyingLottoTicketsAmount.subtract(buyingManualLottoTicketsAmount);

		return getBuyingAutoLottoTicketsCounts(buyingAutoLottoTicketsMoney);
	}

	private int getBuyingAutoLottoTicketsCounts(Money buyingAutoLottoTicketsMoney) {
		BigDecimal buyingAutoLottoTicketsCounts = buyingAutoLottoTicketsMoney.divideBy(lottoPrice);
		return buyingAutoLottoTicketsCounts.intValue();
	}
}
