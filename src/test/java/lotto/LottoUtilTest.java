package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumbers;

public class LottoUtilTest {
	
	@Test
	@DisplayName("로또 번호 생성 테스트")
	void create_random_lottoNumber(){
		assertAll(
				() -> assertThat(LottoUtil.randomLottoNumbers()).hasSize(6),
				() -> assertThat(new LottoNumbers(LottoUtil.randomLottoNumbers()))
		);
	}
	
}
