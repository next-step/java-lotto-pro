package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class PricesTest {
	Prices prices = Prices.from(
		Arrays.asList(
			Price.from(5000),
			Price.from(5000),
			Price.from(5000)
		)
	);

	@Test
	void 합계() {
		assertThat(prices.totalPrice()).isEqualTo(Price.from(15000));
	}
}
