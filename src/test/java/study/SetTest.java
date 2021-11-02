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

	@DisplayName("Set 의 size() 메소드를 활용해 Set 의 크기를 확인한다.")
	@Test
	void size() {
		// given
		// when
		// then
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Set 의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int value) {
		// given
		// when
		// then
		assertThat(numbers.contains(value)).isTrue();
	}

	@DisplayName("1,2,3 값은 contains 메소드 실행결과 true, 4,5 값은 contains 메소드 실행결과 false 를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains2(Integer value, boolean result) {
		// given
		// when
		// then
		assertThat(numbers.contains(value)).isEqualTo(result);
	}
}
