package com.example.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("구매 정보")
class PurchaseInformationTest {

	@DisplayName("구매 정보로부터 구매 금액, 구매할 수동 로또 수, 자동 로또 수, 잔돈을 알 수 있다.")
	@ParameterizedTest
	@CsvSource(value = {
		"10000,10,0,0",
		"14000,3,11,0",
		"10000,3,7,0",
		"11000,2,9,0",
		"11100,2,9,100",
	})
	void constructor(
		long purchaseMoney,
		long manualLottoPurchaseCount,
		long expectedAutoLottoPurchaseCount,
		long expectedChange
	) {
		// given & when
		PurchaseInformation purchaseInformation = PurchaseInformation.of(
			LottoGame.LOTTO_GAME_PRICE,
			purchaseMoney,
			manualLottoPurchaseCount);

		// then
		assertAll(
			() -> assertThat(purchaseInformation).isNotNull(),
			() -> assertThat(purchaseInformation.getPurchaseMoney()).isEqualTo(purchaseMoney),
			() -> assertThat(purchaseInformation.getManualLottoPurchaseCount()).isEqualTo(manualLottoPurchaseCount),
			() -> assertThat(purchaseInformation.getAutoLottoPurchaseCount()).isEqualTo(expectedAutoLottoPurchaseCount),
			() -> assertThat(purchaseInformation.getChange()).isEqualTo(expectedChange)
		);
	}

	@DisplayName("구입 금액보다 많은 로또를 구입할 수 없다.")
	@ParameterizedTest
	@CsvSource(value = {
		"10000,11",
		"10000,12"
	})
	void constructor_fail(long purchaseMoney, long manualLottoPurchaseCount) {
		// given & when & then
		assertThatThrownBy(
			() -> PurchaseInformation.of(LottoGame.LOTTO_GAME_PRICE, purchaseMoney, manualLottoPurchaseCount)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
