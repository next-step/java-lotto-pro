package lotto.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.yield.Yield;
import lotto.view.YieldMessage;

class YieldMessageTest {
	@Test
	void 객체_생성() {
		assertThat(new YieldMessage(Yield.from(1f))).isEqualTo(new YieldMessage(Yield.from(1f)));
	}

	@ParameterizedTest
	@CsvSource(value = {"1.25f:이득", "0.85:손해"}, delimiter = ':')
	void 수익률_결과_메시지(float yield, String benefit) {
		YieldMessage yieldMessage = new YieldMessage(Yield.from(yield));
		assertThat(yieldMessage.toString()).isEqualTo(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", yield, benefit));
	}
}
