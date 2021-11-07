package step3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import step3.winner.Winner;
import step3.winner.WinningAmount;

public class WinnerTest {

	private LottoNumberService lottoNumberService;
	private Map<Integer, Integer> winnerAmounts;
	private Winner winner;
	private LottoPapers papers;

	@BeforeEach
	void setUp() {
		lottoNumberService = new LottoNumberService();
		papers = LottoPapers.createPapers(getLottoNumbers());
	}

	@Test
	@DisplayName("각 로또종이별 매칭되는 수에따른 금액 확인")
	void eachWinAmount() {
		//given
		String userInputWinnerNumber = "1, 2, 3, 4, 5, 6";
		lottoNumberService = new LottoNumberService();

		//when
		winner = new Winner(papers);
		winnerAmounts = winner.statistics(lottoNumberService.convertLottoNumber(userInputWinnerNumber));

		//then
		assertThat(winnerAmounts.get(3)).isEqualTo(5_000);
		assertThat(winnerAmounts.get(4)).isEqualTo(50_000);
	}

	@DisplayName("당첨금액의 총 수익률 계산")
	@ParameterizedTest
	@CsvSource(value = {"1, 2, 3, 4, 5, 6:14000:3.92", "36,42,45,21,30,20:14000:3.92",
		"6,42,45,1,9,8:14000:0.00"}, delimiter = ':')
	void yield(String userInputNumber, int inputMoney, String inputYield) {
		// given
		Money money = new Money(inputMoney);

		// when
		winner = new Winner(papers);
		winnerAmounts = winner.statistics(lottoNumberService.convertLottoNumber(userInputNumber));
		Integer reduce = winnerAmounts.entrySet().stream().map(s -> s.getValue()).reduce(0, Integer::sum);

		// then
		BigDecimal yield = money.yield(reduce);
		assertThat(yield).isEqualTo(new BigDecimal(inputYield));
	}
	
	@DisplayName("각각의 금액이 해당 금액 범위 내인지 확인")
	@ParameterizedTest
	@EnumSource(WinningAmount.class)
	void WinningAmountTest(WinningAmount winningAmount) {
		int amount = winningAmount.getAmount();
		assertTrue(amount >= 5000 && amount <= 2_000_000_000);
	}

	private List<LottoNumbers> getLottoNumbers() {
		Stream<LottoNumbers> lottoNumbersStream = Stream.of(
			LottoNumbers.createLottoNumber(2, 3, 5, 7, 43, 16),
			LottoNumbers.createLottoNumber(18, 3, 36, 42, 45, 30),
			LottoNumbers.createLottoNumber(21, 22, 38, 25, 42, 30),
			LottoNumbers.createLottoNumber(35, 37, 21, 22, 23, 12),
			LottoNumbers.createLottoNumber(1, 2, 3, 4, 41, 25),
			LottoNumbers.createLottoNumber(18, 20, 22, 40, 42, 12),
			LottoNumbers.createLottoNumber(38, 23, 39, 10, 29, 15),
			LottoNumbers.createLottoNumber(2, 19, 36, 11, 44, 13),
			LottoNumbers.createLottoNumber(36, 22, 10, 29, 13, 15),
			LottoNumbers.createLottoNumber(20, 37, 22, 24, 43, 44),
			LottoNumbers.createLottoNumber(37, 38, 24, 25, 9, 27),
			LottoNumbers.createLottoNumber(18, 37, 22, 26, 45, 16),
			LottoNumbers.createLottoNumber(17, 3, 26, 11, 12, 32),
			LottoNumbers.createLottoNumber(17, 35, 6, 40, 26, 42));
		List<LottoNumbers> collect = lottoNumbersStream
			.collect(Collectors.toList());
		return collect;
	}
}
