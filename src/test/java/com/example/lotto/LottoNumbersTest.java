package com.example.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 번호들")
public class LottoNumbersTest {

	private static Stream<Arguments> validNumbers() {
		return Stream.of(
			// valid lotto numbers
			Arguments.of(Arrays.asList(8, 21, 23, 41, 42, 43)),
			// valid but not sorted lotto numbers
			Arguments.of(Arrays.asList(3, 11, 5, 16, 38, 32))
		);
	}

	private static Stream<Arguments> invalidNumbers() {
		return Stream.of(
			// null
			null,
			// empty number
			Arguments.of(Collections.emptyList()),
			// duplicated number
			Arguments.of(Arrays.asList(3, 3, 5, 16, 38, 32)),
			// less than 6 numbers
			Arguments.of(Arrays.asList(3, 5, 16, 38, 32)),
			// more than 6 numbers
			Arguments.of(Arrays.asList(3, 4, 5, 16, 38, 32, 33))
		);
	}

	@DisplayName("로또 번호들을 생성한다. 로또 번호들은 중복되지 않으며 오름차순으로 6개이다.")
	@ParameterizedTest
	@MethodSource("validNumbers")
	void constructor(List<Integer> numbers) {
		// given & when
		LottoNumbers lottoNumbers = new LottoNumbers(numbers);

		// then
		assertAll(
			() -> assertThat(lottoNumbers).isNotNull(),
			() -> assertThat(new HashSet<>(lottoNumbers.getValues())).hasSize(6),
			() -> assertThat(lottoNumbers.getValues()).isSortedAccordingTo(
				Comparator.comparingInt(LottoNumber::getValue)),
			() -> assertThat(lottoNumbers.getValues()).hasSize(6),
			() -> assertThat(lottoNumbers.getValues()).isEqualTo(
				numbers.stream()
					.sorted()
					.map(LottoNumber::new)
					.collect(Collectors.toList()))
		);
	}

	@DisplayName("로또 게임을 생성할 수 없다.")
	@ParameterizedTest
	@MethodSource("invalidNumbers")
	void constructor_fail(List<Integer> numbers) {
		// given & when & then
		assertThatThrownBy(() -> new LottoNumbers(numbers))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
