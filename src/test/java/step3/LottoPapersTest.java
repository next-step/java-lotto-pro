package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.lotto.BonusBall;
import step3.lotto.LottoNumber;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;
import step3.winner.MatchResult;

class LottoPapersTest {

	@Test
	@DisplayName("생성된 로또 수만 큼 생성되는지 확인 ")
	void createPapers() {
		// given
		LottoPapers papers = LottoPapers.createPapers(getLottoNumbers());

		// then
		assertThat(papers.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("당첨번호와 보너스볼의 매칭 확인")
	void matchResultAndBonusBall() {
		// given
		LottoPapers lottoPapers = LottoPapers.createPapers(getLottoNumbers());
		LottoNumbers winningLottoNumbers = LottoNumbers.from("1,5,7,3,5,2");

		// when
		MatchResult findWinningResult = lottoPapers.matchResultAndBonusBall(
			winningLottoNumbers,
			new BonusBall(44));

		// then
		assertThat(findWinningResult.hasMatchCount(4)).isTrue();
		assertThat(findWinningResult.isBonusBalls(4)).isFalse();
	}

	@Test
	void 당첨번호가_5개이상_보너스볼까지_맞춘경우() {
		// given
		LottoPapers lottoPapers = LottoPapers.createPapers(getLottoNumbers());
		LottoNumbers winningLottoNumbers = LottoNumbers.from("1,5,7,3,5,24");

		// when
		MatchResult findWinningResult = lottoPapers.matchResultAndBonusBall(
			winningLottoNumbers,
			new BonusBall(22));

		// then
		assertThat(findWinningResult.hasMatchCount(5)).isTrue();
		assertThat(findWinningResult.isBonusBalls(5)).isTrue();
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