package step3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPapersTest {

	@Test
	@DisplayName("생성된 로또 수만 큼 생성되는지 확인 ")
	void createPapers() {
		// given
		LottoPapers papers = LottoPapers.createPapers(getLottoNumbers());

		// then
		Assertions.assertThat(papers.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("생성된 로또 수만 큼 생성되는지 확인 ")
	void createLottoCount() {
		// given
		LottoPapers lottoPapers = LottoPapers.createPapers(getLottoNumbers());

		// when
		List<Integer> matchLottoNumber = lottoPapers.findMatchLottoNumber(LottoNumbers.from("1,5,7,3,5,2"));

		// then
		Assertions.assertThat(matchLottoNumber.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("생성된 로또와 사용자가 입력한 숫자의 매칭 수가 같은지 확인")
	void findMatchLottoNumber() {
		// given
		LottoPapers lottoPapers = LottoPapers.createPapers(getLottoNumbers());

		// when
		List<Integer> matchLottoNumber = lottoPapers.findMatchLottoNumber(LottoNumbers.from("1,5,7,3,5,2"));

		// then
		Assertions.assertThat(matchLottoNumber.get(0)).isEqualTo(4);
		Assertions.assertThat(matchLottoNumber.get(1)).isEqualTo(2);
	}

	private List<LottoNumbers> getLottoNumbers() {
		Set<LottoNumber> lottoNumber1 = getLottoNumber(1, 5, 7, 3, 24, 22);
		Set<LottoNumber> lottoNumber2 = getLottoNumber(1, 32, 44, 3, 24, 27);
		List<LottoNumbers> collect = Stream.of(new LottoNumbers(lottoNumber1), new LottoNumbers(lottoNumber2))
			.collect(Collectors.toList());
		return collect;
	}

	private Set<LottoNumber> getLottoNumber(Integer ...input) {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		for (Integer integer : input) {
			lottoNumbers.add(new LottoNumber(integer));
		}
		return lottoNumbers;
	}
}