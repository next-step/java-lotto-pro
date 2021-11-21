package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoWinningMoneyTest {

	@DisplayName("로또번호 적중 개수별 금액 확인")
	@ParameterizedTest
	@CsvSource(value = {
		"3,5000",
		"4,50000",
		"5,1500000",
		"6,2000000000",
	})
	public void winningMoneyByMatchedNumberCountTest(int matchedNumberCount, int winningMoney) {
		assertThat(LottoWinningMoney.getMoneyByMatchedNumberCount(matchedNumberCount)).isEqualTo(winningMoney);
	}
}
