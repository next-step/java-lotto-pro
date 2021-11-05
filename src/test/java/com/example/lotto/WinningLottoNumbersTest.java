package com.example.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("당첨 로또 번호들")
class WinningLottoNumbersTest {

	private static Stream<Arguments> validArguments() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 8)
		);
	}

	private static Stream<Arguments> invalidArguments() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 2)
		);
	}

	@DisplayName("당첨 로또 번호들을 생성한다.")
	@ParameterizedTest
	@MethodSource(value = "validArguments")
	void constructor(List<Integer> numbers, int number) {
		// given & when
		WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.of(
			LottoNumbers.of(numbers),
			LottoNumber.of(number));

		// then
		assertThat(winningLottoNumbers).isNotNull();
	}

	@DisplayName("당첨 로또 번호들을 생성할 수 없다.")
	@ParameterizedTest
	@MethodSource(value = "invalidArguments")
	void constructor_fail(List<Integer> numbers, int number) {
		// given & when & then
		assertThatThrownBy(() -> WinningLottoNumbers.of(LottoNumbers.of(numbers), LottoNumber.of(number)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
