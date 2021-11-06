package step3;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinnerTest {

	private LottoNumberService lottoNumberService;
	private Map<Integer, Integer> winnerAmounts;
	private Winner winner;


	@BeforeEach
	void setUp() {
		LottoPapers.getInstance();
		LottoPapers.PAPERS = getLottoNumbers();
		lottoNumberService = new LottoNumberService();
	}

	@Test
	@DisplayName("각 로또종이별 매칭되는 수에따른 금액 확인")
	void eachWinAmount() {
		//given
		String userInputWinnerNumber = "1, 2, 3, 4, 5, 6";
		lottoNumberService = new LottoNumberService();

		//when
		winner = new Winner();
		winnerAmounts = winner.statistics(lottoNumberService.convertLottoNumber(userInputWinnerNumber));

		//then
		assertThat(winnerAmounts.get(3)).isEqualTo(5_000);
		assertThat(winnerAmounts.get(4)).isEqualTo(50_000);
	}

	@DisplayName("당첨금액의 총 수익률 계산")
	@ParameterizedTest
	@CsvSource(value = {"1, 2, 3, 4, 5, 6:14000:3.92", "36,42,45,21,30,20:14000:3.92","6,42,45,1,9,8:14000:0.00"}, delimiter = ':')
	void yield(String userInputNumber, int inputMoney, String inputYield) {
		// given
		Money money = new Money(inputMoney);

		// when
		winner = new Winner();
		winnerAmounts = winner.statistics(lottoNumberService.convertLottoNumber(userInputNumber));
		Integer reduce = winnerAmounts.entrySet().stream().map(s -> s.getValue()).reduce(0, Integer::sum);

		// then
		BigDecimal yield = money.yield(reduce);
		assertThat(yield).isEqualTo(new BigDecimal(inputYield));
	}

	private List<LottoNumbers> getLottoNumbers() {
		Stream<LottoNumbers> lottoNumbersStream = Stream.of(
			new LottoNumbers(getLottoNumber(2, 3, 5, 7, 43, 16)),
			new LottoNumbers(getLottoNumber(18, 3, 36, 42, 45, 30)),
			new LottoNumbers(getLottoNumber(21, 22, 38, 25, 42, 30)),
			new LottoNumbers(getLottoNumber(35, 37, 21, 22, 23, 12)),
			new LottoNumbers(getLottoNumber(1, 2, 3, 4, 41, 25)),
			new LottoNumbers(getLottoNumber(18, 20, 22, 40, 42, 12)),
			new LottoNumbers(getLottoNumber(38, 23, 39, 10, 29, 15)),
			new LottoNumbers(getLottoNumber(2, 19, 36, 11, 44, 13)),
			new LottoNumbers(getLottoNumber(36, 22, 10, 29, 13, 15)),
			new LottoNumbers(getLottoNumber(20, 37, 22, 24, 43, 44)),
			new LottoNumbers(getLottoNumber(37, 38, 24, 25, 9, 27)),
			new LottoNumbers(getLottoNumber(18, 37, 22, 26, 45, 16)),
			new LottoNumbers(getLottoNumber(17, 3, 26, 11, 12, 32)),
			new LottoNumbers(getLottoNumber(17, 35, 6, 40, 26, 42)));
		List<LottoNumbers> collect = lottoNumbersStream
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
