package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottosTest {
	@Test
	public void init_Lottos_생성_확인() {
		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottoList.add(new Lotto(Arrays.asList(1, 4, 5, 6, 7, 8)));
		lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		Lottos lottos = new Lottos(lottoList);

		int lottoCount = lottos.quantity();

		assertThat(lottoCount).isEqualTo(lottoCount);
		assertThat(lottos.toString()).isEqualTo(lottoCount);
	}
}
