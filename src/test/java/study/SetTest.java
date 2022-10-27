package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

	@DisplayName("size 확인")
	@Test
	void size() {
		assertThat(numbers).hasSize(3);
	}

	@DisplayName("값 존재 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int number) {
		assertThat(numbers).contains(number);
	}

	@DisplayName("값 존재 확인, 존재시 true 없을시 false")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains_CsvSource(int number, boolean expected) {
		final boolean actual = numbers.contains(number);
		assertThat(actual).isEqualTo(expected);
	}
}
