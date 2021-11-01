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
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

	@DisplayName("Set의 size()메소드를 통해 Set의 크기가 확인된다.")
	@Test
	void size() {
		// given
		// when
		// then
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set의 Contains()메소드를 활용해 1,2,3의 값이 존재하는지 확인된다.")
	@ParameterizedTest(name = "{index} => Set value [{0}] is contained")
	void contains_onlyExistValues(int value) {
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
	@DisplayName(" 1, 2, 3값은 Contains()메소드의 결과값이 true, 4, 5값은 Contains()메소드 값이 false가 반환된다.")
	@ParameterizedTest(name = "{index} => Contain boolean value of Set value [{0}]  is \"{1}\"")
	void contains_existValuesAndNotExistValues(int value, boolean isContain) {
		// given

		// when

		// then
		assertThat(numbers.contains(value)).isEqualTo(isContain);
	}
}
