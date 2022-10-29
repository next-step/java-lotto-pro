package lotto;

import static lotto.view.LottoWinPrize.FIFTH;
import static lotto.view.LottoWinPrize.FIRST;
import static lotto.view.LottoWinPrize.FOURTH;
import static lotto.view.LottoWinPrize.MISS_EIGHTH;
import static lotto.view.LottoWinPrize.THIRD;
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
				LottoWinPrizes.of(FIFTH),
				FIFTH,
				1),
			Arguments.of(
				LottoWinPrizes.of(FIFTH, FIFTH, FIFTH),
				FIFTH,
				3),
			Arguments.of(
				LottoWinPrizes.of(FIFTH, FOURTH, THIRD, FIRST),
				LottoWinPrize.FIRST,
				1)
		);
	}

	private static Stream<Arguments> 로또_일치_갯수의_예상_수익률_입력() {
		return Stream.of(
			Arguments.of(
				LottoWinPrizes.of(MISS_EIGHTH, MISS_EIGHTH, FIFTH),
				ProfitMargin.valueOf(1.66)),
			Arguments.of(
				LottoWinPrizes.of(MISS_EIGHTH, FIFTH, FIFTH),
				ProfitMargin.valueOf(3.33)),
			Arguments.of(
				LottoWinPrizes.of(FIRST),
				ProfitMargin.valueOf(2_000_000))
		);
	}

}
