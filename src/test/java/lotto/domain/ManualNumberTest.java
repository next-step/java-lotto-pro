package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualNumberTest {
	@DisplayName("수동 횟수 생성")
	@Test
	void generateManualNumber() {
		ManualNumber manualNumber = new ManualNumber(5);

		assertThat(manualNumber).isEqualTo(new ManualNumber(5));
	}

	@DisplayName("수동 횟수가 넘어온 횟수 이상인가?")
	@Test
	void moreThanNumber() {
		ManualNumber manualNumber = new ManualNumber(5);

		boolean moreThanNumber = manualNumber.isMoreThanNumber(2);
		
		assertThat(moreThanNumber).isEqualTo(true);
	}
}
