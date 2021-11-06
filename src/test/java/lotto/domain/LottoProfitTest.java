package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoProfitTest {

	@ParameterizedTest
	@CsvSource(delimiter = ',', value = {
		"12000,5000,0.41",
		"5000,5000,1.00",
		"1000,10000,10.00"
	})
	@DisplayName("주문금액과 총 당첨금이 주어지면 수익률(소수점 2자리) 계산한다")
	public void getProfitTest(int money, int totalPrizeMoney, double profit) {
		// when
		double result = LottoProfit.calculate(totalPrizeMoney, money);

		// then
		assertThat(result).isEqualTo(profit);
	}

}
