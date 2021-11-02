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

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("size 메소드로 Set의 size를 확인 할 수 있다.")
	void testSize() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("contains 메소드로 값이 존재하지는 확인 할 수 있다.")
	void testContains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();

		assertThat(numbers.contains(4)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("ParameterizedTest를 활용해서 중복 코드를 줄일 수 있다.")
	void testContainsUsingParameterizedTest(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("ParameterizedTest와 CsvSource를 활용해서 다양한 케이스를 테스트 할 수 있다.")
	void testContainsUsingCsvSource(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
