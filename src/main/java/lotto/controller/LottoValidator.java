package lotto.controller;

import static java.lang.String.format;

import java.util.List;

import money.Money;

public class LottoValidator {
	private static final String LOTTO_PRICE_ERROR_MESSAGE = "로또 금액은 %s 보다 작을 수 없습니다.";
	private static final String MANUAL_PRICE_ERROR_MESSAGE = "수동으로 구매할 로또 금액이 지불한 금액보다 적습니다.";
	private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

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

	public static void verifyBonusNumberIsNotInWinningLottoNumbers(List<Integer> winningLottoNumbers, int bonusNumber) {
		if (winningLottoNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
		}
	}
}
