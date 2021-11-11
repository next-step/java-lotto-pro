package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.lotto.BonusBall;
import step3.lotto.LottoNumbers;

public class BonusTest {

	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6:1",
		"1,42,3,4,5,6:42"}, delimiter = ':')
	void name(String winningLottoNumbers, int bonusBall) {
		Assertions.assertThatThrownBy(() -> {
			BonusBall.of(bonusBall, LottoNumbers.from(winningLottoNumbers));
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호는 1 ~ 45까지 숫자이어야합니다.")
	@ParameterizedTest()
	@CsvSource(value = {"1,2,3,4,5,6:-1", "1,42,3,4,5,6:0"}, delimiter = ':')
	void lottoNumberIsMinOneAndMaxFiftyFive(String winningLottoNumbers, int number) {
		Assertions.assertThatThrownBy(() -> BonusBall.of(number, LottoNumbers.from(winningLottoNumbers)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또 번호는 1 ~ 45까지 숫자이어야 합니다.");
	}

}
