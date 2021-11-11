import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import model.Lotto;
import model.LottoNumber;
import model.Rank;

public class LottoTest {

	@Test
	@DisplayName("로또 숫자가 6개가 주어지지 않으면 예외")
	void test_constructor1() {
		assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Lotto.MESSAGE_NOT_ALLOW_LENGTH);
	}

	@Test
	@DisplayName("로또 숫자에 중복된 값이 포함되어있으면 예외")
	void test_constructor2() {
		assertThatThrownBy(() -> new Lotto(
			Arrays.asList(1, 1, 3, 4, 5, 7)
		)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Lotto.MESSAGE_NOT_ALLOW_DUPLICATION);
	}

	@Test
	@DisplayName("로또 숫자가 6개가 포함되면서 겹치는 값이 없으면 성공")
	void test_constructor3() {
		assertThat(new Lotto(
			Arrays.asList(1, 2, 3, 4, 5, 6)
		)).isEqualTo(new Lotto(
			Arrays.asList(1, 2, 3, 4, 5, 6)
		));
	}

	@Test
	@DisplayName("로또 숫자 6개가 포함된 문자열로도 생성 가능")
	void test_constructor4() {
		assertThat(new Lotto("1, 2, 3, 4, 5, 6"))
			.isEqualTo(new Lotto(
				Arrays.asList(1, 2, 3, 4, 5, 6)
			));
	}

	@ParameterizedTest
	@DisplayName("당첨 번호를 제공하면 해당하는 Rank 반환")
	@MethodSource("test_calcLotto_parameter")
	void test_calcLotto(List<Integer> userLottoList, List<Integer> winningLotto, int bonusNumber, Rank rank) {
		Lotto lotto = new Lotto(userLottoList);
		Rank lottoResult = lotto.calcLottoResult(new Lotto(winningLotto), new LottoNumber(bonusNumber));

		assertThat(lottoResult).isEqualTo(rank);
	}

	private static Stream<Arguments> test_calcLotto_parameter() {
		int bonusNumberHit = 6;
		int bonusNumberNotHit = 45;

		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6),
				bonusNumberNotHit,
				Rank.FIRST),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7),
				bonusNumberHit, Rank.SECOND),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7),
				bonusNumberNotHit,
				Rank.THIRD),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 7, 8),
				bonusNumberHit, Rank.FOURTH),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 7, 8, 9),
				bonusNumberHit, Rank.FIFTH),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 7, 8, 9, 10),
				bonusNumberHit, Rank.NONE)
		);
	}

	@Test
	@DisplayName("toString이 원하는 포맷으로 나오는지 확인")
	void test_toString() {
		assertThat(new Lotto("1,2,3,4,5,6").toString())
			.matches(Pattern.compile("\\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+]"));
	}
}
