package lotto.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultMessageTest {
	@Test
	void 당첨_등급별_로또_결과_조회() {
		ResultMessage resultMessage = ResultMessage.THREE_MATCH_MESSAGE;
		int quantity = 3;

		assertThat(resultMessage.getResultMessage(3))
			.isEqualTo(String.format("%s- %d개", resultMessage.getMessage(), quantity));
	}
}
