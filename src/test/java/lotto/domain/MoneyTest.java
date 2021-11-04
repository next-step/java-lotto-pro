package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.utils.MessageBuilder;

class MoneyTest {

	@DisplayName("0 이상의 구입금액을 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 10, 100, 500, 1000, 10000, 20000})
	void create1(int seedMoney) {
		// when
		Money money = Money.of(seedMoney);

		// then
		assertThat(money.getValue()).isGreaterThanOrEqualTo(0);
	}

	@DisplayName("구입금액이 0 미만이면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(ints = {-1, -10, -100, -500, -1000, -2000, -30000})
	void create2(int seedMoney) {
		// when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Money.of(seedMoney))
			.withMessage(MessageBuilder.build(INVALID_INPUT_MONEY, seedMoney));
	}
}