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
		Numbers numbers = new Numbers(Arrays.asList(
			new Number(1), new Number(2), new Number(3),
			new Number(4), new Number(5), new Number(6)
		));

		Numbers threeMatch = new Numbers(Arrays.asList(
			new Number(1), new Number(2), new Number(3),
			new Number(20), new Number(35), new Number(45)
		));

		Numbers sixMatch = new Numbers(Arrays.asList(
			new Number(1), new Number(2), new Number(3),
			new Number(4), new Number(5), new Number(6)
		));

		assertThat(numbers.match(threeMatch)).isEqualTo(3);
		assertThat(numbers.match(sixMatch)).isEqualTo(6);
	}

	@Test
	@DisplayName("숫자 중복 기입을 검증")
	void valid_duplication() {
		assertThatThrownBy(() -> new Numbers(Arrays.asList(
				new Number(1), new Number(1), new Number(3),
				new Number(20), new Number(35), new Number(45)
			)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("숫자 포함 여부 확인")
	void contain_number() {
		Numbers numbers = new Numbers(Arrays.asList(
			new Number(1), new Number(2), new Number(3),
			new Number(4), new Number(5), new Number(6)
		));

		assertThat(numbers.isContainNumber(new Number(1))).isTrue();
		assertThat(numbers.isContainNumber(new Number(40))).isFalse();
	}
}
