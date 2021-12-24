package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoOrderCountTest {

	@DisplayName("로또 구매금액별 티켓 구매 개수")
	@ParameterizedTest
	@CsvSource(value = {
		"1000,1",
		"11000,11",
	})
	void lottoOrderCountByLottoMoney(int money, int expectedOrderCount) {
		LottoOrderCount lottoOrderCount = new LottoOrderCount(new LottoMoney(money));
		assertThat(lottoOrderCount.get()).isEqualTo(expectedOrderCount);
	}
}
