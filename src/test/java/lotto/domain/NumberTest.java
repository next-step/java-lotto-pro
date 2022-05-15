package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {
	@ParameterizedTest
	@ValueSource(ints = {-1, 46, 0, 100})
	@DisplayName("로또 번호 범위는 1 이상 45 이하")
	void valid_number(int number) {
		assertThatThrownBy(() -> new Number(number))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
