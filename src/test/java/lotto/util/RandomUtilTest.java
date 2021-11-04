package lotto.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumber;

@DisplayName("랜덤 숫자생성 유틸 테스트")
class RandomUtilTest {

	@DisplayName("랜덤생성시 로또 번호 범위 검증 예외처리 테스트")
	@Test
	void 랜덤생성시_로또_번호_범위_검증_예외처리_테스트() {
		// given // when // then
		assertThatThrownBy(() -> {
			RandomUtil.pickNumber(0, 8);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또번호 랜덤 생성 테스트")
	@RepeatedTest(value = 100)
	void 로또번호_랜덤_생성_테스트() {
		// given
		int min = LottoNumber.MIN_LOTTO_NUMBER;
		int max = LottoNumber.MAX_LOTTO_NUMBER;

		// when
		int lottoNumber = RandomUtil.pickNumber(min, max);

		// then
		assertThat(lottoNumber).isBetween(min, max);
	}
}