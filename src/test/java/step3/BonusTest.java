package step3;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.lotto.BonusBall;
import step3.lotto.LottoNumber;
import step3.lotto.LottoNumbers;
import step3.winner.Winning;

public class BonusTest {

	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6:1",
		"1,42,3,4,5,6:42"}, delimiter = ':')
	void name(String winningLottoNumbers, int bonusBall) {
		Assertions.assertThatThrownBy(() -> {
			new Winning(LottoNumbers.from(winningLottoNumbers), new BonusBall(bonusBall));
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호는 1 ~ 45까지 숫자이어야합니다.")
	@ParameterizedTest()
	@CsvSource(value = {"1,2,3,4,5,6:-1", "1,42,3,4,5,6:0"}, delimiter = ':')
	void lottoNumberIsMinOneAndMaxFiftyFive(String winningLottoNumbers, int bonusBall) {
		Assertions.assertThatThrownBy(() -> new Winning(LottoNumbers.from(winningLottoNumbers), new BonusBall(bonusBall)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또 번호는 1 ~ 45까지 숫자이어야 합니다.");
	}

	@Test
	void 대칭성_검증() {
		BonusBall bonusBall = new BonusBall(3);
		LottoNumber lottoNumber = new LottoNumber(3);
		assertThat(bonusBall.asLottoNumber()).isEqualTo(lottoNumber);
	}

	@Test
	void 추이성_검증() {
		BonusBall bonusBallX = new BonusBall(3);
		LottoNumber lottoNumberY = new LottoNumber(3);
		BonusBall bonusBallZ = new BonusBall(3);

		assertThat(bonusBallX.asLottoNumber()).isEqualTo(lottoNumberY);
		assertThat(lottoNumberY).isEqualTo(bonusBallZ.asLottoNumber());
		assertThat(bonusBallX.asLottoNumber()).isEqualTo(bonusBallZ.asLottoNumber());
	}


}
