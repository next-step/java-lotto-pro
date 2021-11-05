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

	private static Stream<Arguments> rankArguments() {
		NumbersGenerator dummyNumbersGenerator = (from, to, size) -> Arrays.asList(1, 2, 3, 4, 5, 6);

		return Stream.of(
			Arguments.of(
				LottoGame.of(dummyNumbersGenerator),
				WinningLottoNumbers.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(45)),
				LottoRank.FIRST),
			Arguments.of(
				LottoGame.of(dummyNumbersGenerator),
				WinningLottoNumbers.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7)), LottoNumber.of(6)),
				LottoRank.SECOND),
			Arguments.of(
				LottoGame.of(dummyNumbersGenerator),
				WinningLottoNumbers.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7)), LottoNumber.of(45)),
				LottoRank.THIRD),
			Arguments.of(
				LottoGame.of(dummyNumbersGenerator),
				WinningLottoNumbers.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 7, 8)), LottoNumber.of(45)),
				LottoRank.FOURTH),
			Arguments.of(
				LottoGame.of(dummyNumbersGenerator),
				WinningLottoNumbers.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 7, 8, 9)), LottoNumber.of(45)),
				LottoRank.FIFTH),
			Arguments.of(
				LottoGame.of(dummyNumbersGenerator),
				WinningLottoNumbers.of(LottoNumbers.of(Arrays.asList(1, 2, 7, 8, 9, 10)), LottoNumber.of(45)),
				LottoRank.MISS)
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
		LottoGame lottoGame = LottoGame.of((from, to, size) -> numbers);

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
		assertThatThrownBy(() -> LottoGame.of((from, to, size) -> numbers))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 순위를 구한다.")
	@ParameterizedTest
	@MethodSource("rankArguments")
	void rank(LottoGame lottoGame, WinningLottoNumbers winningLottoNumbers, LottoRank lottoRank) {
		// given & when & then
		assertThat(lottoGame.rank(winningLottoNumbers)).isEqualTo(lottoRank);
	}
}
