package step3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPapersTest {

	@Test
	@DisplayName("인스턴스를 두번 생성했을 때 데이터를 담는 순간 정보가 바뀌지 않는지 확인")
	void createPapers() {
		List<LottoNumbers> lottoPapers = getLottoNumbers();
		LottoPapers.createPapers(getLottoNumbers());
	}

	private List<LottoNumbers> getLottoNumbers() {
		Set<LottoNumber> lottoNumber1 = getLottoNumber(1, 5, 7, 8, 4, 1,5,42);
		Set<LottoNumber> lottoNumber2 = getLottoNumber(1, 9, 5, 3, 2, 1,24);
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