package model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또들")
class LottosTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> Lottos.from(Collections.singleton(mock(Lotto.class))));
	}

	@Test
	@DisplayName("로또가 비어있는 상태에서 객체화하면 IllegalArgumentException")
	void instance_nullLottoPrice_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Lottos.from(null))
			.withMessage("lotto collection must not be null");
	}

	@Test
	@DisplayName("당첨된 금액 계산")
	void score() {
		//given
		Lotto mockLotto = mock(Lotto.class);
		when(mockLotto.rank(any(Lotto.class)))
			.thenReturn(LottoRank.FOURTH);

		LottoGenerator mockLottoGenerator = mock(LottoGenerator.class);
		when(mockLottoGenerator.lotto())
			.thenReturn(mockLotto);

		//when
		Score score = Lottos.from(Arrays.asList(mockLotto, mockLotto))
			.score(mockLottoGenerator);

		//then
		assertThat(score.prizeMoney())
			.isEqualTo(Money.from(10_000));
	}
}
