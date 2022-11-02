package lotto.domain.amount;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class AmountsTest {
	Amounts amounts = Amounts.from(
		Arrays.asList(
			Amount.from(5000),
			Amount.from(5000),
			Amount.from(5000)
		)
	);

	@Test
	void 합계() {
		assertThat(amounts.totalPrice()).isEqualTo(Amount.from(15000));
	}
}
