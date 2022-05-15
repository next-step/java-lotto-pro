package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {
	@Test
	@DisplayName("번호 일치 개수를 검증")
	void numbers_match() {
		Numbers numbers = new Numbers(Arrays.asList(1, 2, 4, 5, 16, 20));
		Numbers threeMatch = new Numbers(Arrays.asList(1, 2, 4, 26, 29, 40));
		Numbers sixMatch = new Numbers(Arrays.asList(1, 2, 4, 5, 16, 20));

		assertThat(numbers.match(threeMatch)).isEqualTo(3);
		assertThat(numbers.match(sixMatch)).isEqualTo(6);
	}

	@Test
	@DisplayName("숫자 중복 기입을 검증")
	void valid_duplication() {
		assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 1, 3, 4, 5, 6)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
