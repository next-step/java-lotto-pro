package lotto.controller;

import static lotto.controller.LottoValidator.verifyBonusNumberIsNotInWinningLottoNumbers;
import static lotto.controller.LottoValidator.verifyManualLottoTotalPriceIsLessThanBillingMoney;
import static lotto.controller.LottoValidator.verifyMoneyIsEqualToOrGreaterThanPrice;

import java.math.BigDecimal;
import java.util.List;

import lotto.controller.dto.BoughtLottoResponse;
import lotto.controller.dto.LottoWinResultRequest;
import lotto.controller.dto.LottoWinResultsResponse;
import lotto.domain.AutoLottoTicketsVendor;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinPrizes;
import money.Money;

public class LottoController {

	private final AutoLottoTicketsVendor autoLottoTicketsVendor;
	private final Money lottoPrice;

	public LottoController(Money lottoPrice, AutoLottoTicketsVendor autoLottoTicketsVendor) {
		this.lottoPrice = lottoPrice;
		this.autoLottoTicketsVendor = autoLottoTicketsVendor;
	}

	public BoughtLottoResponse buyLottoTickets(int buyingLottoTicketsMoney,
											   List<List<Integer>> manualLottoNumbers) {
		Money lottoTicketsMoney = Money.wons(buyingLottoTicketsMoney);
		verifyLottoInput(manualLottoNumbers, lottoTicketsMoney);

		return buyLottoTickets(lottoTicketsMoney, manualLottoNumbers);
	}

	private void verifyLottoInput(List<List<Integer>> manualLottoNumbers, Money lottoTicketsMoney) {
		verifyMoneyIsEqualToOrGreaterThanPrice(lottoPrice, lottoTicketsMoney);
		verifyManualLottoTotalPriceIsLessThanBillingMoney(lottoTicketsMoney, lottoPrice, manualLottoNumbers.size());
	}

	public BoughtLottoResponse buyLottoTickets(Money buyingLottoTicketsAmount,
											   List<List<Integer>> manualLottoNumbers) {
		int buyingAutoLottoTicketsCount = getBuyingAutoLottoTicketsCounts(buyingLottoTicketsAmount, manualLottoNumbers);

		LottoTickets manualLottoTickets = LottoTickets.ofList(manualLottoNumbers);
		LottoTickets autoLottoTickets = autoLottoTicketsVendor.buyAutoLottoTickets(buyingAutoLottoTicketsCount);

		return BoughtLottoResponse.of(manualLottoTickets, autoLottoTickets);
	}

	public LottoWinResultsResponse getWinResults(LottoWinResultRequest request) {
		verifyBonusNumberIsNotInWinningLottoNumbers(request.getWinningLottoNumbers(), request.getBonusNumber());

		LottoTickets boughtLottoTickets = request.getBoughtLottoTickets();
		LottoTicket winningLottoTicket = LottoTicket.of(request.getWinningLottoNumbers());

		LottoWinPrizes lottoWinPrizes = boughtLottoTickets.match(winningLottoTicket, request.getBonusNumber());

		return LottoWinResultsResponse.of(lottoWinPrizes, lottoPrice);
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
