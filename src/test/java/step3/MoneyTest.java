package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {
	@Test
	void 금액이_천원보다작다면_예외() {
		Assertions.assertThatThrownBy(() -> {
			Money money = new Money(900);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("금액이 부족합니다.");
	}

	@ParameterizedTest
	@DisplayName("입력한 금액에따라 구매가능한 갯수를 리턴")
	@CsvSource(value = {"1000:1","2000:2","1100:1"}, delimiter = ':')
	void buyCount(int input, int result) {
		Money money = new Money(input);
		Assertions.assertThat(money.buyCount()).isEqualTo(result);
	}
}
