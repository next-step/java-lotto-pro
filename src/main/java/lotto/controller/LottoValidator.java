package lotto.controller;

import static java.lang.String.format;

import money.Money;

public class LottoValidator {
	private static final String LOTTO_PRICE_ERROR_MESSAGE = "로또 금액은 %s 보다 작을 수 없습니다.";
	private static final String MANUAL_PRICE_ERROR_MESSAGE = "수동으로 구매할 로또 금액이 지불한 금액보다 적습니다.";

	public static void verifyManualLottoTotalPriceIsLessThanBillingMoney(Money lottoTicketsMoney,
																		 Money lottoPrice,
																		 int manualLottoNumberCount) {
		Money manualLottoTotalPrice = lottoPrice.multiply(manualLottoNumberCount);
		if (lottoTicketsMoney.isLessThan(manualLottoTotalPrice)) {
			throw new IllegalArgumentException(MANUAL_PRICE_ERROR_MESSAGE);
		}
	}

	public static void verifyMoneyIsEqualToOrGreaterThanPrice(Money lottoPrice, Money lottoTicketsMoney) {
		if (lottoTicketsMoney.isLessThan(lottoPrice)) {
			throw new IllegalArgumentException(format(LOTTO_PRICE_ERROR_MESSAGE, lottoPrice));
		}
	}
}
