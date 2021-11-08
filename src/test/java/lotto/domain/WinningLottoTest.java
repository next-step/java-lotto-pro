package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)));
		lottoList.add(new Lotto(Arrays.asList(1, 11, 12, 13, 14, 15)));
		lottoList.add(new Lotto(Arrays.asList(1, 11, 12, 13, 14, 15)));
		Lottos lottos = new Lottos(lottoList);

		WinningRecord winningRecord = winningLotto.match(lottos);

		assertThat(winningRecord.getPlaceCount(Rank.FIRST_PLACE)).isEqualTo(1);
		assertThat(winningRecord.getPlaceCount(Rank.SECOND_PLACE)).isEqualTo(2);
	}
}
