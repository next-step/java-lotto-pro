package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("로또 결과 생성 여부 테스트")
	public void LottosRuesltTest() {
		//given
		Lottos lottos = IntStream.range(1, 6).mapToObj(value -> new Lotto(11, 12, 13, 14, 15, value))
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
		WinningLotto winningLotto = new WinningLotto("11, 12, 13, 14, 15, 16", 9);
		//when
		int WinnerCount = lottos.createLottoResult(winningLotto).countWinner(Rank.THIRD);
		//then
		assertThat(WinnerCount).isEqualTo(5);
	}

	@Test
	@DisplayName("로또 합치기 테스트")
	public void addAllTest() {
		//given
		//when
		Lottos lottos = IntStream.range(1, 6).mapToObj(value -> new Lotto(11, 12, 13, 14, 15, value))
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
		Lottos otherLottos = IntStream.range(1, 4).mapToObj(value -> new Lotto(11, 12, 13, 14, 15, value))
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
		//then
		assertThat(lottos.addAll(otherLottos).size()).isEqualTo(8);
	}

}

