package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import money.Money;
import view.LottoWinPrize;

class LottoWinResultsTest {

	final Money 로또_한장_가격 = Money.wons(1000);

	@ParameterizedTest
	@MethodSource("로또_상금_순위_갯수_입력")
	void 로또_일치_갯수를_입력하면_상금_순위의_갯수를_알_수_있다(LottoMatchCounts 로또_일치_갯수들, LottoWinPrize 상금_순위, int 상금_순위_갯수) {
		LottoWinResults 로또_당첨_결과 = LottoWinResults.computeWinResult(로또_일치_갯수들);

		assertThat(로또_당첨_결과.getWinPrizeCount(상금_순위)).isEqualTo(상금_순위_갯수);
	}

	@ParameterizedTest
	@MethodSource("로또_일치_갯수의_예상_수익률_입력")
	void 로또를_구입한_가격과_당첨금을_통해_총_수익률을_계산할_수_있다(LottoMatchCounts 로또_일치_갯수들, ProfitMargin 예상_수익률) {
		LottoWinResults 로또_당첨_결과 = LottoWinResults.computeWinResult(로또_일치_갯수들);

		ProfitMargin 수익률 = 로또_당첨_결과.getProfitMargin(로또_한장_가격);

		assertThat(수익률).isEqualTo(예상_수익률);
	}

	private static Stream<Arguments> 로또_일치_갯수의_예상_수익률_입력() {
		return Stream.of(
			Arguments.of(
				LottoMatchCounts.of(Lists.newArrayList(0, 0, 3)),
				ProfitMargin.valueOf(1.66)),
			Arguments.of(
				LottoMatchCounts.of(Lists.newArrayList(0, 3, 3)),
				ProfitMargin.valueOf(3.33)),
			Arguments.of(
				LottoMatchCounts.of(Lists.newArrayList(6)),
				ProfitMargin.valueOf(2_000_000))
		);
	}

	private static Stream<Arguments> 로또_상금_순위_갯수_입력() {
		return Stream.of(
			Arguments.of(
				LottoMatchCounts.of(Lists.newArrayList(3)),
				LottoWinPrize.THREE_MATCHES,
				1),
			Arguments.of(
				LottoMatchCounts.of(Lists.newArrayList(3, 3, 3)),
				LottoWinPrize.THREE_MATCHES,
				3),
			Arguments.of(
				LottoMatchCounts.of(Lists.newArrayList(3, 4, 5, 6)),
				LottoWinPrize.SIX_MATCHES,
				1)
		);
	}

}
