package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	private WinningLotto winningLotto;


	@BeforeEach
	void setUp() {
		winningLotto = new WinningLotto(Arrays.asList(10, 11, 12, 13, 14, 15));
	}

	@Test
	public void 로또_당첨_번호_생성() {
		assertThat(winningLotto).isEqualTo(new WinningLotto(Arrays.asList(10, 11, 12, 13, 14, 15)));
	}

	@Test
	public void 로또_순위_반환() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 13, 14, 15, 45));

		Rank rank = winningLotto.match(lotto);

		assertThat(rank).isEqualTo(Rank.FOURTH_PLACE);
	}
}
