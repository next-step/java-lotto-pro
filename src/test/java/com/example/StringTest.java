package com.example;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

	@DisplayName("\"1,2\"을 `,`로 split 했을 때 \"1\"과 \"2\"로 분리한다.")
	@Test
	public void requirement_1_1() {
		// given
		String given = "1,2";

		// when
		String[] actual = given.split(",");

		// then
		String[] expected = {"1", "2"};
		assertThat(actual).contains(expected);
	}

	@DisplayName("\"1\"을 `,`로 split 했을 때 \"1\"만을 포함하는 배열이 반환된다.")
	@Test
	public void requirement_1_2() {
		// given
		String given = "1";

		// when
		String[] actual = given.split(",");

		// then
		String[] expected = {"1"};
		assertThat(actual).containsExactly(expected);
	}

	@DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 `()`을 제거하고 \"1,2\"를 반환한다.")
	@Test
	public void requirement_2() {
		// given
		String given = "(1,2)";

		// when
		String actual = given.substring(1, 4);

		// then
		String expected = "1,2";
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
	@ParameterizedTest
	@CsvSource(value = {
		"0,a",
		"1,b",
		"2,c",
	})
	public void requirement_3_1(int index, char expected) {
		// given
		String given = "abc";

		// when
		char actual = given.charAt(index);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"3", "4"})
	public void requirement_3_2(int index) {
		// given
		String given = "abc";

		// when & then
		Assertions.assertThatThrownBy(() -> given.charAt(index))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageMatching("String index out of range: \\d+");
	}
}
