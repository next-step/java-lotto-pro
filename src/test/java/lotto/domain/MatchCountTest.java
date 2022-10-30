package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchCountTest {

	@Test
	void 객쳬_생성() {
		assertThat(MatchCount.from(3)).isEqualTo(MatchCount.from(3));
	}

}
