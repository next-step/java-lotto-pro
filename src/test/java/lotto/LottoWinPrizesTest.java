package lotto;

import static lotto.view.LottoWinPrize.FIVE_MATCHES;
import static lotto.view.LottoWinPrize.FOUR_MATCHES;
import static lotto.view.LottoWinPrize.SIX_MATCHES;
import static lotto.view.LottoWinPrize.THREE_MATCHES;
import static lotto.view.LottoWinPrize.ZERO_MATCHES;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.LottoWinPrizes;
import lotto.domain.ProfitMargin;
import lotto.view.LottoWinPrize;
import money.Money;

class LottoWinPrizesTest {

	Money 로또_한장_가격 = Money.wons(1000);

	@ParameterizedTest
	@MethodSource("로또_상금_순위_갯수_입력")
	void 로또_일치_갯수를_입력하면_상금_순위의_갯수를_알_수_있다(LottoWinPrizes 로또_당첨_결과, LottoWinPrize 상금_순위, int 상금_순위_갯수) {
		assertThat(로또_당첨_결과.getWinPrizeCount(상금_순위)).isEqualTo(상금_순위_갯수);
	}

	@ParameterizedTest
	@MethodSource("로또_일치_갯수의_예상_수익률_입력")
	void 로또를_구입한_가격과_당첨금을_통해_총_수익률을_계산할_수_있다(LottoWinPrizes 로또_당첨_결과, ProfitMargin 예상_수익률) {
		ProfitMargin 수익률 = 로또_당첨_결과.getProfitMargin(로또_한장_가격);

		assertThat(수익률).isEqualTo(예상_수익률);
	}

	private static Stream<Arguments> 로또_상금_순위_갯수_입력() {
		return Stream.of(
			Arguments.of(
				LottoWinPrizes.of(THREE_MATCHES),
				THREE_MATCHES,
				1),
			Arguments.of(
				LottoWinPrizes.of(THREE_MATCHES, THREE_MATCHES, THREE_MATCHES),
				THREE_MATCHES,
				3),
			Arguments.of(
				LottoWinPrizes.of(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, SIX_MATCHES),
				LottoWinPrize.SIX_MATCHES,
				1)
		);
	}

	private static Stream<Arguments> 로또_일치_갯수의_예상_수익률_입력() {
		return Stream.of(
			Arguments.of(
				LottoWinPrizes.of(ZERO_MATCHES, ZERO_MATCHES, THREE_MATCHES),
				ProfitMargin.valueOf(1.66)),
			Arguments.of(
				LottoWinPrizes.of(ZERO_MATCHES, THREE_MATCHES, THREE_MATCHES),
				ProfitMargin.valueOf(3.33)),
			Arguments.of(
				LottoWinPrizes.of(SIX_MATCHES),
				ProfitMargin.valueOf(2_000_000))
		);
	}

}
