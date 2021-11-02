package junit;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection에 대한 학습 테스트")
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

	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
	@Test
	void setSizeTest() {
		// given // when
		int size = numbers.size();
		// then
		assertThat(size).isEqualTo(3);
	}

	@DisplayName("Set의 contains() 메소드를 활용 값이 존재하는지 확인하는 테스트")
	@ParameterizedTest(name = "{index} ==> number {0}")
	@ValueSource(ints = {1, 2, 3})
	void setContainsParameterizedTest(int value) {
		// given // when // then
		assertThat(numbers.contains(value)).isTrue();
	}

	@DisplayName("CsvSource를 활용하여 입력 값에 따라 다른 결과 값을 확인하는 테스트")
	@ParameterizedTest(name = "{index} ==> number {0}, result {1}")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
	void setContainsCsvSourceParameterizedTest(int number, boolean result) {
		// given // when // then
		assertThat(numbers.contains(number)).isEqualTo(result);
	}
}
