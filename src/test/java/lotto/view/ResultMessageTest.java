package lotto.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.lotto.MatchRank;

class ResultMessageTest {
	@Test
	void 당첨_등급별_로또_결과_조회() {
		int quantity = 3;
		ResultMessage resultMessage = new ResultMessage(MatchRank.SECOND, quantity);

		assertThat(resultMessage.toString()).isEqualTo("5개 일치, 보너스 볼 일치(30000000원)- 3개");
	}
}
