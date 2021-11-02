package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set 자료구조에서")
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

	@DisplayName("size()메소드를 활용해 크기가 확인된다.")
	@Test
	void size() {
		// given
		// when
		// then
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Contains()메소드를 활용해")
	@Nested
	class constains {
		@ValueSource(ints = {1, 2, 3})
		@DisplayName("1, 2, 3의 값이 존재하는지 확인된다.")
		@ParameterizedTest(name = "{index} => Set value [{0}] is contained")
		void onlyExistValues(int value) {
			// given

			// when

			// then
			assertThat(numbers.contains(value)).isTrue();
		}

		@CsvSource({"1, true",
					"2, true",
					"3, true",
					"4, false",
					"5, false"})
		@DisplayName(" 1, 2, 3값은 true, 4, 5값은 값은 false가 반환된다.")
		@ParameterizedTest(name = "{index} => Contain boolean value of Set value [{0}]  is \"{1}\"")
		void existValuesAndNotExistValues(int value, boolean isContain) {
			// given

			// when

			// then
			assertThat(numbers.contains(value)).isEqualTo(isContain);
		}
	}
}
