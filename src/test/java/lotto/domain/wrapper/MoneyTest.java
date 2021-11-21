package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
	@DisplayName("금액 생성")
	@Test
	public void lottoNumberCountIsSix() {
		double given = 5000;
		Money money = new Money(given);
		assertThat(money.get()).isEqualTo(given);
	}
}
