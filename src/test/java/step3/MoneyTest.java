package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {
	@Test
	void 금액이_천원보다작다면_예외() {
		Assertions.assertThatThrownBy(() -> {
			Money money = new Money(900);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("금액이 부족합니다.");
	}
}
