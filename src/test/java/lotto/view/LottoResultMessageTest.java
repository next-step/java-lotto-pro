package lotto.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.lotto.MatchRank;
import lotto.domain.quantity.Quantity;

class LottoResultMessageTest {
	@Test
	void 당첨_등급별_로또_결과_조회() {
		MatchRank matchRank = MatchRank.THREE_MATCH;
		Quantity quantity = Quantity.from(5);
		LottoResultMessage lottoResultMessage = new LottoResultMessage(matchRank, quantity);

		assertThat(lottoResultMessage.toString())
			.isEqualTo(String.format("%d개 일치 (%d원)- %d", matchRank.getMatchCount(), matchRank.getWinningPrice(),
				quantity.getInt()));
	}
}
