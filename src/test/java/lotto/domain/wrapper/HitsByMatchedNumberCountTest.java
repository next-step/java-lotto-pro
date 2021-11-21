package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HitsByMatchedNumberCountTest {

	@DisplayName("로또번호 적중 시 hits 증가")
	@Test
	public void addWhenMatchedNumberCountHitsTest() {
		int matchedNumberCount = 3;

		HitsByMatchedNumberCount hitsByMatchedNumberCount = new HitsByMatchedNumberCount();

		assertThat(hitsByMatchedNumberCount.get().get(matchedNumberCount)).isEqualTo(0);
		hitsByMatchedNumberCount.hit(matchedNumberCount);
		assertThat(hitsByMatchedNumberCount.get().get(matchedNumberCount)).isEqualTo(1);
	}
}
