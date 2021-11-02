package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.DisplayName.class)
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
	@DisplayName("1. Set.size()가 중복된 요소 제거를 반영하는지 크기를 반환하는지 확인")
	void test_size1() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	@DisplayName("2. Set.contains가 추가한 요소에 true를 반환하는지 확인")
	void test_contains1(int element) {
		assertThat(numbers.contains(element)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
	@DisplayName("3. Set.contains가 추가한 요소에는 true를, 추가하지 않은 요소에는 false를 반환하는지 확인")
	void test_contains2(int element, boolean isContain) {
		assertThat(numbers.contains(element)).isEqualTo(isContain);
	}
}
