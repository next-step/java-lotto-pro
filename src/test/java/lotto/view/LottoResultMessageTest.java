package lotto.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.lotto.MatchRank;
import lotto.domain.quantity.Quantity;

class LottoResultMessageTest {
	@Test
	void 당첨_등급별_로또_결과_조회() {
		MatchRankMessage matchRankMessage = MatchRankMessage.THREE_MATCH_MESSAGE;
		Quantity quantity = Quantity.from(5);

		assertThat(new LottoResultMessage(matchRankMessage, quantity).toString())
			.isEqualTo(String.format("%s- %d개", matchRankMessage.getMessage(), quantity.getInt()));
	}
}
