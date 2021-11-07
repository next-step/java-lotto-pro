package common;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessagesTest {

	@Test
	@DisplayName("{arg} 있는 메시지 파라미터로 formatting하여 반환한다.")
	public void MessagesReplaceFormatValue() {
		assertAll(() -> {
			assertThat(Messages.BOUGHT_OF_FORMAT.getValues(new String[] {"3", "11"}))
				.isEqualTo("수동으로 3장, 자동으로 11개를 구매했습니다.");
			assertThat(Messages.RESULT_FORMAT.getValues(new String[] {"2.11"})).isEqualTo("총 수익률은 2.11입니다.");
		});
	}
}