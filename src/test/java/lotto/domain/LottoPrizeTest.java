package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPrizeTest {

    @Test
    void 로또_번호가_5개_동일하고_보너스볼이_같지_않으면_3등() {
        assertThat(LottoPrize.findLottoPrize(5, false)).isEqualTo(LottoPrize.THIRD);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:true", "2:true", "0:false", "1:false", "2:false"}, delimiter = ':')
    void 로또_번호가_2개_이하로_동일하면_NO_PRIZE(int matchCount, boolean isMatchBonusLottoNumber) {
        assertThat(LottoPrize.findLottoPrize(matchCount, isMatchBonusLottoNumber)).isEqualTo(LottoPrize.NO_PRIZE);
    }

    @Test
    void isNoPrize의_매개변수가_NO_PRIZE_이면_isNoPrize는_진실() {
        assertThat(LottoPrize.isNoPrize(LottoPrize.NO_PRIZE)).isTrue();
    }

    @Test
    void isNoPrize의_매개변수가_NO_PRIZE가_아니면_isNoPrize는_진실() {
        assertThat(LottoPrize.isNoPrize(LottoPrize.SECOND)).isFalse();
    }

    @Test
    void 로또_번호가_5개_동일하고_보너스볼이_같으면_2등() {
        assertThat(LottoPrize.findLottoPrize(5, true)).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    void 로또_번호가_4개_동일하면_보너스볼과_상관_없이_4등() {
        assertAll(
                () -> assertThat(LottoPrize.findLottoPrize(4, true)).isEqualTo(LottoPrize.FOURTH),
                () -> assertThat(LottoPrize.findLottoPrize(4, false)).isEqualTo(LottoPrize.FOURTH)
        );
    }
}
