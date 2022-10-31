package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	void 객체_생성() {
		assertThat(Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(
			Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	@Test
	void 로또_번호_문자열_반환() {
		assertThat(Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6)).getResultMessage()).isEqualTo(
			"[1, 2, 3, 4, 5, 6]");
		assertThat(Lotto.inputNumber(Arrays.asList(6, 5, 4, 3, 2, 1)).getResultMessage()).isEqualTo(
			"[1, 2, 3, 4, 5, 6]");
	}

	@Test
	void 로또_번호_포함_여부() {
		assertThat(Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6)).contains(LottoNumber.from(1))).isTrue();
		assertThat(Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6)).contains(LottoNumber.from(7))).isFalse();
	}

	@Test
	void 로또_일치_갯수_확인() {
		Lotto lotto = Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto.countMatchCount(Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(
			MatchCount.from(6));
		assertThat(lotto.countMatchCount(Lotto.inputNumber(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(
			MatchCount.from(5));
		assertThat(lotto.countMatchCount(Lotto.inputNumber(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(
			MatchCount.from(4));
		assertThat(lotto.countMatchCount(Lotto.inputNumber(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(
			MatchCount.from(3));
		assertThat(lotto.countMatchCount(Lotto.inputNumber(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(
			MatchCount.from(2));
		assertThat(lotto.countMatchCount(Lotto.inputNumber(Arrays.asList(6, 7, 8, 9, 10, 11)))).isEqualTo(
			MatchCount.from(1));
		assertThat(lotto.countMatchCount(Lotto.inputNumber(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(
			MatchCount.from(0));
	}
}
