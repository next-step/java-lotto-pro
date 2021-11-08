package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IssueQuantityTest {

	@DisplayName("자동 타입의 수량 확인")
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void 자동_수량_확인(int autoQuantity) {
		assertThat(new IssueQuantity().auto(autoQuantity).getAutoQuantity()).isEqualTo(autoQuantity);
	}

	@DisplayName("수동 타입의 수량 확인")
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void 수동_수량_확인(int manualQuantity) {
		assertThat(new IssueQuantity().manual(manualQuantity).getManualQuantity()).isEqualTo(manualQuantity);
	}

}
