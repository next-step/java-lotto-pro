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
	@DisplayName("set의 size 메서드를 활용한 test")
	public void setSize() {
	    assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("parametrizedTest 를 활용한 1,2,3 케이스 true 확인 성공")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void parameterizedTestSuccess(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("parameterizedTest > CsvSource를 활용한 결과값비교 확인 성공")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	public void parameterizedWithExpectedValueSuccessOrFail(int value, Boolean expected) {
		assertThat(numbers.contains(value)).isEqualTo(expected);
	}
	
}
