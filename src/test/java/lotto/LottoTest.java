package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constants.Rank;
import lotto.model.Lotto;
import lotto.model.WinLotto;

public class LottoTest {
	WinLotto winlotto;

	@BeforeEach
	void setUp() {
		winlotto = new WinLotto(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)), 10);
	}

	@Test
	@DisplayName("Lotto 생성 실패 테스트(숫자 부족)")
	void generateLack() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Lotto(Arrays.asList(1, 2, 3, 4, 5));
		});
	}

	@Test
	@DisplayName("Lotto 생성 실패 테스트(중복 숫자)")
	void generateDuplicate() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
		});
	}

	@Test
	@DisplayName("Lotto 생성 실패 테스트(숫자 범위)")
	void generateRange() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 47));
		});
	}

	@Test
	@DisplayName("Lotto 1등 테스트")
	void lottoFirst() {
		Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
		assertThat(winlotto.compare(lotto)).isEqualTo(Rank.FIRST);
	}

	@Test
	@DisplayName("Lotto 2등 테스트")
	void lottoSecond() {
		Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 10));
		assertThat(winlotto.compare(lotto)).isEqualTo(Rank.SECOND);
	}

	@Test
	@DisplayName("Lotto 3등 테스트")
	void lottoThird() {
		Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 11));
		assertThat(winlotto.compare(lotto)).isEqualTo(Rank.THIRD);
	}

	@Test
	@DisplayName("Lotto 4등 테스트")
	void lottoFourth() {
		Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 7, 28, 29));
		assertThat(winlotto.compare(lotto)).isEqualTo(Rank.FOURTH);
	}

	@Test
	@DisplayName("Lotto 5등 테스트")
	void lottoFifth() {
		Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 41, 42, 43));
		assertThat(winlotto.compare(lotto)).isEqualTo(Rank.FIFTH);
	}
}
