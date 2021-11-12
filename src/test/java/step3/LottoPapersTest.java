package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.lotto.BonusBall;
import step3.lotto.LottoNumber;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;
import step3.winner.Rank;
import step3.winner.WinningResult;

class LottoPapersTest {

	@Test
	@DisplayName("생성된 로또 수만 큼 생성되는지 확인 ")
	void createPapers() {
		// given
		LottoPapers papers = LottoPapers.createPapers(getLottoNumbers());

		// then
		assertThat(papers.size()).isEqualTo(2);
	}

	@ParameterizedTest
	@DisplayName("당첨번호, 보너스볼 매칭 순위확인")
	@CsvSource(value = {
		"1,5,7,3,42,2:44:4",
		"1,5,7,3,42,29:22:2"},delimiter = ':')
	void matchResultAndBonusBall(String inputWinningLottoNumbers, int bonusBall, int rankNumber) {
		// given
		LottoPapers lottoPapers = LottoPapers.createPapers(getLottoNumbers());
		LottoNumbers winningLottoNumbers = LottoNumbers.from(inputWinningLottoNumbers);

		// when
		WinningResult findWinningResult = lottoPapers.findMatchWinningResult(
			winningLottoNumbers,
			new BonusBall(bonusBall));

		// then
		assertThat(findWinningResult.containsRank(Rank.valueOf(rankNumber))).isTrue();
	}


	private List<LottoNumbers> getLottoNumbers() {
		Set<LottoNumber> lottoNumber1 = getLottoNumber(1, 5, 7, 3, 24, 22);
		Set<LottoNumber> lottoNumber2 = getLottoNumber(1, 32, 44, 3, 24, 27);
		List<LottoNumbers> collect = Stream.of(new LottoNumbers(lottoNumber1), new LottoNumbers(lottoNumber2))
			.collect(Collectors.toList());
		return collect;
	}

	private Set<LottoNumber> getLottoNumber(Integer... input) {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		for (Integer integer : input) {
			lottoNumbers.add(new LottoNumber(integer));
		}
		return lottoNumbers;
	}
}