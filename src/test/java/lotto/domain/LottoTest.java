package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.constant.ErrorCode;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또가_6개_숫자로_이루어지지_않으면_에러_발생() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.로또는_6개의_숫자로_이루어져야함.getErrorMessage());
    }

    @Test
    void 로또의_각_숫자는_중복되면_에러_발생() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(1), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.로또의_각_숫자는_중복_불가.getErrorMessage());
    }

    @Test
    void 구매한_로또와_당첨_번호간_3개_일치_테스트() {
        Lotto prizeLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto inputLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(3), new LottoNumber(4)
                , new LottoNumber(24), new LottoNumber(35), new LottoNumber(45)));
        assertThat(inputLotto.findLottoPrize(prizeLotto)).isEqualTo(LottoPrize.FOURTH);
    }

    @Test
    void 구매한_로또와_당첨_번호간_4개_일치_테스트() {
        Lotto prizeLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto inputLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(3), new LottoNumber(4)
                , new LottoNumber(5), new LottoNumber(35), new LottoNumber(45)));
        assertThat(inputLotto.findLottoPrize(prizeLotto)).isEqualTo(LottoPrize.THIRD);
    }
}
