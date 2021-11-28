package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.wrapper.LottoOrderRequest;

public class LottoOrderRequestTest {
	@DisplayName("주문금액별 로또 수량 검증")
	@ParameterizedTest
	@CsvSource(value = {
		"1500,1",
		"14000,14",
		"1401000,1401",
	})
	public void lottoOrderTest(int orderPrice, int expectedOrderCount) {
		assertThat(LottoOrderRequest.byPrice(orderPrice))
			.isEqualTo(LottoOrderRequest.byOrderCount(expectedOrderCount));
	}
}
