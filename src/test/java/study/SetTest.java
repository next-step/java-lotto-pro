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
	@DisplayName("크기 확인")
	void size() {
		//when
		int size = numbers.size();

		//then
		assertThat(size)
			.isEqualTo(3);
	}

	@ParameterizedTest(name = "{displayName}[{index}] {0} is contained in the set")
	@DisplayName("항상 포함되는 대상 확인")
	@ValueSource(ints = {1, 2, 3})
	void contains_alwaysTrue(int containsTarget) {
		//when
		boolean contains = numbers.contains(containsTarget);

		//then
		assertThat(contains)
			.isTrue();
	}

	@ParameterizedTest(name = "{displayName}[{index}] it is {1} that {0} is contained in the set")
	@DisplayName("포함 여부")
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
	void contains(int containsTarget, boolean expected) {
		//when
		boolean contains = numbers.contains(containsTarget);

		//then
		assertThat(contains)
			.isEqualTo(expected);
	}

}
