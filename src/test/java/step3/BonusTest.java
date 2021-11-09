package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusTest {

	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4,5,6:1", "1,42,3,4,5,6:42"}, delimiter = ':')
	void name(String userLottoNumbers, int bonusBall) {
		Assertions.assertThatThrownBy(() -> {
			BonusBall.of(bonusBall, LottoNumbers.from(userLottoNumbers));
		}).isInstanceOf(IllegalArgumentException.class);
	}


}
