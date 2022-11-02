package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	void 돈_최소값_검사() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Money(-1L))
			.withMessage("돈은 0보다 작을수 없다.");
	}

	@Test
	void 특정_금액의_구입_가능_갯수_확인() {
		Money money = new Money(14001L);
		assertThat(money.calculateQuantity(Lotto.LOTTO_PRICE)).isEqualTo(14L);
	}

	@Test
	void 특정_금액과의_비율_비교() {
		Money money = new Money(14000L);
		assertThat(money.ratio(new Money(5000L))).isEqualTo(0.35f);
	}

	@Test
	void 특정_금액_차감_계산() {
		Money money = new Money(14000L);
		assertThat(money.minus(new Money(5000L))).isEqualTo(new Money(9000L));
	}
}
