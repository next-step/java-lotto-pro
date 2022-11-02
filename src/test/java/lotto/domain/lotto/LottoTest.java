package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	void 객체_생성() {
		Assertions.assertThat(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(
			Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	@Test
	void 같은_로또_번호_입력시_IllegalArgumentException() {
		assertThatThrownBy(() -> Lotto.from(Arrays.asList(1, 1, 1, 1, 1, 1)))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 1)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또_번호_포함_여부() {
		assertThat(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)).contains(LottoNumber.from(1))).isTrue();
		assertThat(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)).contains(LottoNumber.from(7))).isFalse();
	}

	@Test
	void 로또_일치_갯수_확인() {
		Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto.countMatchCount(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
		assertThat(lotto.countMatchCount(Lotto.from(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(5);
		assertThat(lotto.countMatchCount(Lotto.from(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(4);
		assertThat(lotto.countMatchCount(Lotto.from(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(3);
		assertThat(lotto.countMatchCount(Lotto.from(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(2);
		assertThat(lotto.countMatchCount(Lotto.from(Arrays.asList(6, 7, 8, 9, 10, 11)))).isEqualTo(1);
		assertThat(lotto.countMatchCount(Lotto.from(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(0);
	}

	@Test
	void 로또_번호_갯수_6개_제한() {
		assertThatThrownBy(() -> Lotto.from(Arrays.asList(1, 2, 3, 4)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
