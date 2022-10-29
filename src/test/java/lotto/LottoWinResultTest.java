package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import money.Money;

class LottoWinResultTest {

	@ParameterizedTest
	@MethodSource("로또_일치_갯수_입력")
	void 로또를_구입한_가격과_당첨금을_통해_총_수익률을_계산할_수_있다(Money 구입가격, LottoMatchCounts 일치_갯수, ProfitMargin 예상_수익률) {

		ProfitMargin profitMargin = LottoWinResult.computeProfitMargin(구입가격, 일치_갯수);

		assertThat(profitMargin).isEqualTo(예상_수익률);
	}

	private static Stream<Arguments> 로또_일치_갯수_입력() {
		return Stream.of(
			Arguments.of(
				Money.wons(3 * 5000),
				LottoMatchCounts.of(Lists.newArrayList(3)),
				ProfitMargin.valueOf(0.33)),
			Arguments.of(
				Money.wons(3 * 5000),
				LottoMatchCounts.of(Lists.newArrayList(3, 3)),
				ProfitMargin.valueOf(0.66)),
			Arguments.of(
				Money.wons(5000),
				LottoMatchCounts.of(Lists.newArrayList(6)),
				ProfitMargin.valueOf(400000))
		);
	}
}
