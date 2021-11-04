package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetUtilsTest {

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
	@DisplayName("Set의 size() 메소드로 Set의 크기를 확인")
	void sizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
	@ValueSource(ints = {1, 2, 3})
	void containsTest1(int input) {
		assertTrue(numbers.contains(input));
	}

	@ParameterizedTest
	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값은 있고 4, 5가 없는 것을 확인")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void containsTest2(int input, boolean expected) {
		boolean actual = numbers.contains(input);
		assertEquals(expected, actual);
	}
}
