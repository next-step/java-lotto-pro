package step3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {

	private List<Integer> statistics;
	private Winner winner;

	@BeforeEach
	void setUp() {
		LottoPapers.getInstance();
		LottoPapers.PAPERS = getLottoNumbers();
		String userInputWinnerNumber = "1, 2, 3, 4, 5, 6";
		winner = new Winner();
		statistics = winner.statistics(userInputWinnerNumber);
	}

	@Test
	@DisplayName("각 로또번호가 맞는 수만큼 금액 산정")
	void eachWinAmount() {
		Assertions.assertThat(statistics).containsExactly(5_000, 50_000);
	}

	@Test
	@DisplayName("당첨금액의 총 수익률 계산")
	void yield() {
		Money money = new Money(2000);
		Assertions.assertThat(winner.yield(money)).isEqualTo(27);
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
