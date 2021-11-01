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
	@DisplayName("크기를 반환해야 한다")
	public void sizeTest() {
		// given
		int expectedSize = 3;

		// when
		int resultSize = numbers.size();

		// then
		assertThat(resultSize).isEqualTo(expectedSize);
	}

	@ParameterizedTest
	@DisplayName("저장된 요소이면 true를 반환해야 한다")
	@ValueSource(strings = {"1", "2", "3"})
	public void containsTest(int element) {
		// given, when, then
		assertThat(numbers.contains(element))
			.as("%s는 Set에 저장되어 있어야 합니다", element)
			.isTrue();
	}

	@ParameterizedTest
	@DisplayName("저장된 요소면 true를 아니면 false를 반환해야 한다")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	public void containsTest2(int element, boolean expected) {
		// given, when, then
		assertThat(numbers.contains(element))
			.isEqualTo(expected);
	}

}
