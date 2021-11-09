package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	private Lottos lottos;

	@BeforeEach
	void setUp() {
		List<Lotto> lottosStuff = new ArrayList<>();
		lottosStuff.add(
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toSet())
			)
		);
		lottosStuff.add(
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toSet())
			)
		);
		lottos = new Lottos(lottosStuff);
	}

	@DisplayName("로또 당첨번호 기록 확인")
	@Test
	void winningLottoMatch() {
		WinningLotto winningLotto = new WinningLotto(
			Arrays.asList(1, 2, 3, 4, 5, 6)
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toSet()));

		WinningRecord winningRecord = winningLotto.match(lottos);
		int secondCount = winningRecord.getPlaceCount(Rank.SECOND);

		assertThat(secondCount).isEqualTo(1);
	}

}
