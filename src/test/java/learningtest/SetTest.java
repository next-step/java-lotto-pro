package learningtest;

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

	@DisplayName("size: Set의 원소 갯수 반환 메서드 학습테스트")
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("contains: Set에 element가 포함되어있는지 여부 반환 메서드 학습테스트. ParameterizedTest로 복수개 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int element) {
		assertThat(numbers.contains(element)).isTrue();
	}

	@DisplayName("CsvSource로 각각의 element에 따른 예상값을 파라미터화")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void containsIncludeFalseCase(int element, boolean expectedIsExist) {
		assertThat(numbers.contains(element)).isEqualTo(expectedIsExist);
	}
}
