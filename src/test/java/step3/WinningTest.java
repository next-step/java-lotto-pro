package step3;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import step3.lotto.BonusBall;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;
import step3.winner.Rank;
import step3.winner.Winning;
import step3.winner.WinningMoney;
import step3.winner.WinningResult;

public class WinningTest {

	private LottoPapers papers;

	@BeforeEach
	void setUp() {
		papers = LottoPapers.createPapers(getLottoNumbers());
	}

	@Test
	@DisplayName("매칭되는 수에따른 금액 확인")
	void eachWinAmount() {
		//given
		Winning winning = new Winning(LottoNumbers.from("1, 2, 3, 4, 5, 6"), new BonusBall(45));
		WinningResult winningResult = winning.match(papers);
		int total = winningResult.getTotal();
		Assertions.assertThat(total).isEqualTo(Rank.FIRST.getAmount());
	}

	@DisplayName("당첨금액의 총 수익률 계산")
	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6:4000:500000.00",
		"36,42,45,21,32,20:4000:7500.00",
		"6,42,45,1,9,8:4000:1.25",
		"4,3,5,7,43,44:4000:1.25",
		"7,8,9,10,11,12:4000:0.00"}, delimiter = ':')
	void yield(String winningLottoNumbers, int inputMoney, String inputYield) {
		// given
		Winning winning = new Winning(LottoNumbers.from(winningLottoNumbers), new BonusBall(30));
		WinningResult winningResult = winning.match(LottoPapers.createPapers(getLottoNumbers()));

		// when
		int total = winningResult.getTotal();
		BigDecimal bigDecimal = WinningMoney.calculateYield(new Money(inputMoney), total);

		// then
		assertEquals(inputYield, bigDecimal.toString());
	}

	@DisplayName("각각의 금액이 해당 금액 범위 내인지 확인")
	@ParameterizedTest
	@EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"MISS"})
	void WinningAmountTest(Rank winningAmount) {
		int amount = winningAmount.getAmount();
		assertTrue(amount >= 5_000 && amount <= 2_000_000_000);
	}

	private List<LottoNumbers> getLottoNumbers() {
		Stream<LottoNumbers> lottoNumbersStream = Stream.of(
			LottoNumbers.createLottoNumber(1, 2, 3, 4, 5, 6),
			LottoNumbers.createLottoNumber(36, 42, 45, 21, 32, 30),
			LottoNumbers.createLottoNumber(6, 42, 45, 43, 44, 41),
			LottoNumbers.createLottoNumber(31, 32, 33, 34, 35, 36));
		List<LottoNumbers> collect = lottoNumbersStream
			.collect(Collectors.toList());
		return collect;
	}
}
