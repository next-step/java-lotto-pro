package lotto.controller;

import static java.lang.String.format;

import java.math.BigDecimal;
import java.util.List;

import lotto.controller.dto.BoughtLottoTicketsResponse;
import lotto.controller.dto.LottoWinResultsResponse;
import lotto.domain.AutoLottoTicketsVendor;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinPrizes;
import money.Money;

public class LottoControllerImpl implements LottoController {

	public static final String LOTTO_PRICE_ERROR_MESSAGE = "로또 금액은 %s 보다 작을 수 없습니다.";

	private final AutoLottoTicketsVendor autoLottoTicketsVendor;
	private final Money lottoPrice;

	public LottoControllerImpl(Money lottoPrice, AutoLottoTicketsVendor autoLottoTicketsVendor) {
		this.lottoPrice = lottoPrice;
		this.autoLottoTicketsVendor = autoLottoTicketsVendor;
	}

	public BoughtLottoTicketsResponse buyLottoTickets(int buyingLottoTicketsMoney,
													  List<List<Integer>> manualLottoNumbers) {
		Money lottoTicketsMoney = Money.wons(buyingLottoTicketsMoney);
		verifyMoneyIsEqualToOrGreaterThanPrice(lottoTicketsMoney);

		return buyLottoTickets(lottoTicketsMoney, manualLottoNumbers);
	}

	private void verifyMoneyIsEqualToOrGreaterThanPrice(Money lottoTicketsMoney) {
		if (lottoTicketsMoney.isLessThan(lottoPrice)) {
			throw new IllegalArgumentException(format(LOTTO_PRICE_ERROR_MESSAGE, lottoPrice));
		}
	}

	public BoughtLottoTicketsResponse buyLottoTickets(Money buyingLottoTicketsAmount,
													  List<List<Integer>> manualLottoNumbers) {
		int buyingAutoLottoTicketsCount = getBuyingAutoLottoTicketsCounts(buyingLottoTicketsAmount, manualLottoNumbers);

		LottoTickets manualLottoTickets = createManualLottoTickets(manualLottoNumbers);
		LottoTickets autoLottoTickets = buyAutoLottoTickets(buyingAutoLottoTicketsCount);

		return BoughtLottoTicketsResponse.of(manualLottoTickets, autoLottoTickets);
	}

	public LottoWinResultsResponse getWinResults(BoughtLottoTicketsResponse boughtLottoTicketsResponse,
												 List<Integer> winningLottoNumbers,
												 int bonusNumber) {
		LottoTickets boughtLottoTickets = boughtLottoTicketsResponse.toLottoTickets();
		LottoTicket winningLottoTicket = LottoTicket.of(winningLottoNumbers);

		LottoWinPrizes lottoWinPrizes = boughtLottoTickets.match(winningLottoTicket, bonusNumber);

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
