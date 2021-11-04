package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoRankTest {

	@Test
	@DisplayName("1등 로또번호가 주어지면, 1등이어야 한다")
	public void firstRankTest() {
		LottoNumber winningNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber number1st = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));

		LottoRank rank1st = new LottoRank(winningNumber, number1st);

		assertThat(rank1st.isFirst()).isTrue();
		assertThat(rank1st.isSecond()).isFalse();
		assertThat(rank1st.isThird()).isFalse();
		assertThat(rank1st.isFourth()).isFalse();
	}

	@Test
	@DisplayName("2등 로또번호가 주어지면, 2등이어야 한다")
	public void secondRankTest() {
		LottoNumber winningNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber number2st = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 10));

		LottoRank rank2st = new LottoRank(winningNumber, number2st);

		assertThat(rank2st.isSecond()).isTrue();
		assertThat(rank2st.isFirst()).isFalse();
		assertThat(rank2st.isThird()).isFalse();
		assertThat(rank2st.isFourth()).isFalse();
	}

	@Test
	@DisplayName("3등 로또번호가 주어지면, 3등이어야 한다")
	public void thirdRankTest() {
		LottoNumber winningNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber number3st = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 11, 10));

		LottoRank rank3st = new LottoRank(winningNumber, number3st);

		assertThat(rank3st.isThird()).isTrue();
		assertThat(rank3st.isFirst()).isFalse();
		assertThat(rank3st.isSecond()).isFalse();
		assertThat(rank3st.isFourth()).isFalse();
	}

	@Test
	@DisplayName("4등 로또번호가 주어지면, 4등이어야 한다")
	public void fourthRankTest() {
		LottoNumber winningNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber number4st = LottoNumber.of(Arrays.asList(1, 2, 3, 12, 11, 10));

		LottoRank rank4st = new LottoRank(winningNumber, number4st);

		assertThat(rank4st.isFourth()).isTrue();
		assertThat(rank4st.isFirst()).isFalse();
		assertThat(rank4st.isSecond()).isFalse();
		assertThat(rank4st.isThird()).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 5})
	@DisplayName("순위는 1~4위로 이루어져야 한다")
	public void outOfRankTest(int rank) {
		// when, then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new LottoRank(rank));
	}
}
