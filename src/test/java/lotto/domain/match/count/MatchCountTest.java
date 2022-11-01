package lotto.domain.match.count;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.match.count.MatchCount;

class MatchCountTest {

	@Test
	void 객쳬_생성() {
		assertThat(MatchCount.from(3)).isEqualTo(MatchCount.from(3));
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 7})
	void 일치_횟수_범위_제한(int matchCount) {
		assertThatThrownBy(() -> MatchCount.from(matchCount))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
