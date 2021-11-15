package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
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
				.map(LottoNumber::of)
				.collect(Collectors.toSet())
			)
		);
		lottosStuff.add(
			new Lotto(Stream.of(1, 2, 3, 4, 5, 10)
				.map(LottoNumber::of)
				.collect(Collectors.toSet())
			)
		);
		lottos = new Lottos(lottosStuff);
	}

	@DisplayName("로또 당첨번호 기록 확인 1등")
	@Test
	void winningLottoMatch_FIRST() {
		WinningLotto winningLotto = new WinningLotto(
			new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
				.map(LottoNumber::of)
				.collect(Collectors.toSet())),
			LottoNumber.of(7)
		);

		WinningRecord winningRecord = winningLotto.match(lottos);
		int secondCount = winningRecord.getPlaceCount(Rank.FIRST);

		assertThat(secondCount).isEqualTo(1);
	}

	@DisplayName("로또 당첨번호 기록 확인 2등")
	@Test
	void winningLottoMatch_SECOND_AND_THIRD() {
		WinningLotto winningLotto = new WinningLotto(
			new Lotto(Stream.of(1, 2, 3, 4, 5, 8)
				.map(LottoNumber::of)
				.collect(Collectors.toSet())),
			LottoNumber.of(6)
		);
		WinningRecord winningRecord = winningLotto.match(lottos);

		int rankCount = winningRecord.getPlaceCount(Rank.SECOND);

		assertThat(rankCount).isEqualTo(1);

		rankCount = winningRecord.getPlaceCount(Rank.THIRD);

		assertThat(rankCount).isEqualTo(1);
	}

	@DisplayName("순위 반환 보너스 볼 중복")
	@Test
	void matchDuplicateBonusNumber() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 8)
					.map(LottoNumber::of)
					.collect(Collectors.toSet()));
				LottoNumber lottoNumber = LottoNumber.of(2);

				new WinningLotto(lotto, lottoNumber);
			}).withMessageMatching("보너스 볼이 중복되었습니다.");
	}

}
