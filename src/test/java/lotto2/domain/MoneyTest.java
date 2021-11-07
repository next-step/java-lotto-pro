package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

	@ParameterizedTest
	@ValueSource(ints = {13000, 1000, 100, 0})
	@DisplayName("숫자를 통해 생성할 수 있다")
	public void ofTest(int inputMoney) {
		// when
		Money money = Money.of(inputMoney);

		// then
		assertThat(money).isEqualTo(Money.of(inputMoney));
		assertThat(money.toInt()).isEqualTo(inputMoney);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -1000})
	@DisplayName("0이상의 정수여야 한다")
	public void ofValidateTest(int inputMoney) {
		// when, then
		assertThatThrownBy(() -> Money.of(inputMoney))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
