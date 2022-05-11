package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		// given
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set 크기 검증")
	@Test
	void set_size() {
		// when, then
		assertThat(numbers).hasSize(3);
	}

	@DisplayName("Parameter 이용한 contains 검증")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void set_contains(int param) {
		// when, then
		assertThat(numbers.contains(param)).isTrue();
	}

	@DisplayName("CsvSource 이용한 기대값 검증")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void csvSource_test(int param, boolean isExpected) {
		// when, then
		assertThat(numbers.contains(param)).isEqualTo(isExpected);
	}
}
