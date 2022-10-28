package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	void 특정_금액의_구입_가능_갯수_확인() {
		Money money = new Money(14001L);
		assertThat(money.calculateQuantity(new Money(1000L))).isEqualTo(14L);
	}

	@Test
	void 특정_금액과의_비율_비교() {
		Money money = new Money(14000L);
		Assertions.assertThat(money.ratio(new Money(5000L))).isEqualTo(0.35f);
	}
}
