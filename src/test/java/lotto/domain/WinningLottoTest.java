package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	private Lottos lottos;

	@BeforeEach
	void setUp() {
		List<Lotto> lottosStuff = new ArrayList<>();
		lottosStuff.add(
			new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNumber::new)
				.collect(Collectors.toSet())
			)
		);
		lottosStuff.add(
			new Lotto(Stream.of(1, 2, 3, 4, 5, 10)
				.map(LottoNumber::new)
				.collect(Collectors.toSet())
			)
		);
		lottos = new Lottos(lottosStuff);
	}

	@DisplayName("로또 당첨번호 기록 확인 1등")
	@Test
	void winningLottoMatch_FIRST() {
		WinningLotto winningLotto = new WinningLotto(
			Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNumber::new)
				.collect(Collectors.toSet()));

		WinningRecord winningRecord = winningLotto.match(lottos, new LottoNumber(7));
		int secondCount = winningRecord.getPlaceCount(Rank.FIRST);

		assertThat(secondCount).isEqualTo(1);
	}

	@DisplayName("로또 당첨번호 기록 확인 2등")
	@Test
	void winningLottoMatch_SECOND_AND_THIRD() {
		WinningLotto winningLotto = new WinningLotto(
			Stream.of(1, 2, 3, 4, 5, 8)
				.map(LottoNumber::new)
				.collect(Collectors.toSet()));
		WinningRecord winningRecord = winningLotto.match(lottos, new LottoNumber(6));

		int rankCount = winningRecord.getPlaceCount(Rank.SECOND);

		assertThat(rankCount).isEqualTo(1);

		rankCount = winningRecord.getPlaceCount(Rank.THIRD);

		assertThat(rankCount).isEqualTo(1);
	}

	@DisplayName("순위 반환 보너스 볼 중복")
	@Test
	void matchDuplicateBonusNumber(){
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinningLotto winningLotto = new WinningLotto(
					Stream.of(1, 2, 3, 4, 5, 8)
						.map(LottoNumber::new)
						.collect(Collectors.toSet()));
				LottoNumber bonusNumber = new LottoNumber(2);

				winningLotto.match(lottos, bonusNumber);

			}).withMessageMatching("보너스 볼이 중복되었습니다.");
	}

}
