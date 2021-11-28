package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
	@DisplayName("금액 생성")
	@Test
	public void createMoneyTest() {
		BigDecimal given = BigDecimal.valueOf(5000);
		assertThat(new Money(given).get()).isEqualTo(given);
	}
}
