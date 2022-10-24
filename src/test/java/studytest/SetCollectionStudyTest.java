package studytest;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetCollectionStudyTest {
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
	@DisplayName("Set 의 size() 는 Set 의 크기를 반환")
	void setSizeTest() {
		assertThat(numbers).hasSize(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set 의 contains() 는 Set 에 특정 값이 포함되어 있는지 확인")
	void setContainsTest(int input) {
		assertThat(numbers).contains(input);
	}

	@ParameterizedTest(name = "{index} => input={0}, expected={1}")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("Set 의 contains() 는 Set 에 특정 값이 포함되어 있는지 확인")
	void setContainsUsingCsvSourceTest(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
