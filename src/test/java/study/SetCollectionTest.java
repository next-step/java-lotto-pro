package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("set Size 확인")
	@Test
	void size() {
		int result = numbers.size();
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("contains 확인")
	@Test
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
		assertThat(numbers.contains(4)).isFalse();
		assertThat(numbers.contains(5)).isFalse();
	}

	@DisplayName("contains 중복 제거 후 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void containsParameterized(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("CsvSorce를 이용한 결과 값이 다른 경우에 대한 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void containsCsvSource(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}

}
