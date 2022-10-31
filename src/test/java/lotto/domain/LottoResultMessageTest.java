package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoResultMessageTest {
	@Test
	void 일치_횟수별_로또_결과_조회() {
		MatchCount matchCount = MatchCount.from(3);
		Quantity quantity = Quantity.from(5);
		LottoResultMessage lottoResultMessage = new LottoResultMessage(matchCount, quantity);

		assertThat(lottoResultMessage.toString())
			.isEqualTo(String.format("%d개 일치 (%d원)- %d", matchCount.getInt(), matchCount.winningPrice().getLong(),
				quantity.getInt()));
	}
}
