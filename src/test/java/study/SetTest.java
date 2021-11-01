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

@DisplayName("Set 컬렉션")
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

	@Test
	@DisplayName("크기")
	void size() {
		assertThat(numbers.size())
			.isEqualTo(3);
	}

	@ParameterizedTest
	@DisplayName("항상 포함되는 대상")
	@ValueSource(ints = {1, 2, 3})
	void contains_alwaysTrue(int containsTarget) {
		assertThat(numbers.contains(containsTarget))
			.isTrue();
	}

	@ParameterizedTest
	@DisplayName("포함 여부")
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
	void contains(int containsTarget, boolean expected) {
		assertThat(numbers.contains(containsTarget))
			.isEqualTo(expected);
	}

}
