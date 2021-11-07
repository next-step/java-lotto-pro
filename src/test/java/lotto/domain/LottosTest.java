package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottosTest {
	private List<Lotto> lottoList;
	private Lottos lottos;

	@BeforeEach
	void setUp() {
		lottoList = new ArrayList<>();
		lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottoList.add(new Lotto(Arrays.asList(1, 4, 5, 6, 7, 8)));
		lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos = new Lottos(lottoList);
	}

	@Test
	public void init_Lottos_생성_확인() {
		int lottoCount = lottos.quantity();

		assertThat(lottoCount).isEqualTo(lottoCount);
		assertThat(lottos.toString()).isEqualTo(lottoCount);
	}

	@Test
	public void 로또_순위_반환() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 13, 14, 15, 45));
		List<Rank> rank = lottos.match(lotto);
		assertThat(rank).contains(Rank.FOURTH_PLACE, Rank.FIRST_PLACE);
	}
}
