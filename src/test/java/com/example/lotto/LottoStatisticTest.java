package com.example.lotto;

import java.util.Arrays;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 통계")
class LottoStatisticTest {
	private static Stream<Arguments> arguments() {
		return Stream.of(
			Arguments.of(
				PurchaseInformation.of(
					LottoGame.LOTTO_GAME_PRICE,
					10000L,
					2
				),
				LottoGames.manual(
					Arrays.asList(
						Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(7, 8, 9, 10, 11, 12)
					)
				),
				WinningLottoNumbers.of(
					LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
					LottoNumber.of(45)
				),
				200_000d
			),
			Arguments.of(
				PurchaseInformation.of(
					LottoGame.LOTTO_GAME_PRICE,
					10000L,
					2
				),
				LottoGames.manual(
					Arrays.asList(
						Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(7, 8, 9, 10, 11, 12)
					)
				),
				WinningLottoNumbers.of(
					LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7)),
					LottoNumber.of(6)
				),
				3_000d
			),
			Arguments.of(
				PurchaseInformation.of(
					LottoGame.LOTTO_GAME_PRICE,
					10000L,
					2
				),
				LottoGames.manual(
					Arrays.asList(
						Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(9, 10, 11, 12, 13, 14)
					)
				),
				WinningLottoNumbers.of(
					LottoNumbers.of(Arrays.asList(1, 2, 3, 7, 8, 9)),
					LottoNumber.of(6)
				),
				0.5d
			)
		);
	}

	@DisplayName("수익률을 계산한다.")
	@ParameterizedTest
	@MethodSource("arguments")
	void getEarningsRate(
		PurchaseInformation purchaseInformation,
		LottoGames lottoGames,
		WinningLottoNumbers winningLottoNumbers,
		double earningsRate
	) {
		// given & when
		LottoStatistic lottoStatistic = LottoStatistic.of(
			purchaseInformation,
			lottoGames,
			winningLottoNumbers);

		// then
		Assertions.assertThat(lottoStatistic.getEarningsRate()).isEqualTo(earningsRate);
	}
}
