package set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set의 크기를 확인한다")
	@Test
	void size() {
		assertThat(numbers).hasSize(3);
	}

	@DisplayName("Set에 1, 2, 3의 값이 존재하는 지 확인한다")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("Set에 1, 2, 3의 값이 존재하고 4, 5의 값이 존재하지 않는 지 확인한다")
	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
	void contains_not(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
}
