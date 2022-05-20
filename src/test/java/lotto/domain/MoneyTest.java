package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
	@ParameterizedTest
	@ValueSource(ints = {-2, -10, -30000})
	@DisplayName("0 이상의 숫자 입력 검증")
	void valid_number(int number) {
		assertThatThrownBy(() -> new Money(number))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
