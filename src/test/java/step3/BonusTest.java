package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.lotto.BonusBall;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;
import step3.winner.Rank;
import step3.winner.Winning;

public class BonusTest {

	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4,5,6:1", "1,42,3,4,5,6:42"}, delimiter = ':')
	void name(String userLottoNumbers, int bonusBall) {
		Assertions.assertThatThrownBy(() -> {
			BonusBall.of(bonusBall, LottoNumbers.from(userLottoNumbers));
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호는 1 ~ 45까지 숫자이어야합니다.")
	@ParameterizedTest()
	@CsvSource(value = {"1,2,3,4,5,6:-1", "1,42,3,4,5,6:0"}, delimiter = ':')
	void lottoNumberIsMinOneAndMaxFiftyFive(String userLottoNumbers, int number) {
		Assertions.assertThatThrownBy(() -> BonusBall.of(number, LottoNumbers.from(userLottoNumbers)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또 번호는 1 ~ 45까지 숫자이어야 합니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {
		"24,25,26,28,42,30:24,25,26,28,42,14:30",
		"34,44,24,11,23,22:34,44,24,11,23:22"}, delimiter = ':')
	void 이등_당첨(String enterLottoPapers, String enterUserLottoNumbers, int bonusBall) {
		LottoPapers lottoPapers = LottoPapers.createPapers(Arrays.asList(LottoNumbers.from(enterLottoPapers)));
		LottoNumbers userLottoNumber = LottoNumbers.from(enterUserLottoNumbers);

		// when
		Winning winning = Winning.of();
		Winning statistics = winning.statistics(userLottoNumber, lottoPapers, BonusBall.of(bonusBall, userLottoNumber));
		List<Rank> ranks = statistics.getRank();

		// then
		assertThat(ranks.size()).isEqualTo(1);
		assertThat(ranks.get(0)).isEqualTo(Rank.SECOND);
	}

}
