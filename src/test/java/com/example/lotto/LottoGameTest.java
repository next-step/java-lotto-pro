package com.example.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 게임")
class LottoGameTest {

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

	@DisplayName("로또 게임의 가격은 1000원이다.")
	@Test
	void price() {
		// given & when & then
		assertThat(LottoGame.LOTTO_GAME_PRICE).isEqualTo(1000);
	}

	@DisplayName("로또 게임을 생성한다. 중복되지 않는 오름차순의 6개 로또 번호들을 갖는다.")
	@ParameterizedTest
	@MethodSource("validNumbers")
	void constructor(List<Integer> numbers) {
		// given & when
		LottoGame lottoGame = new LottoGame((from, to, size) -> numbers);

		// then
		assertAll(
			() -> assertThat(lottoGame).isNotNull(),
			() -> assertThat(lottoGame.getLottoNumbers()).isNotNull()
		);
	}

	@DisplayName("로또 게임을 생성할 수 없다.")
	@ParameterizedTest
	@MethodSource("invalidNumbers")
	void constructor_fail(List<Integer> numbers) {
		// given & when & then
		assertThatThrownBy(() -> new LottoGame((from, to, size) -> numbers))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
