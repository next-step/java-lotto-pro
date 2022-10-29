package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.constant.ErrorCode;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또가_6개_숫자로_이루어지지_않으면_에러_발생() {
        assertThatThrownBy(() -> Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.로또는_6개의_숫자로_이루어져야함.getErrorMessage());
    }

    @Test
    void 로또의_각_숫자는_중복되면_에러_발생() {
        assertThatThrownBy(() -> Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 1, 3, 4, 5, 6")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.로또의_각_숫자는_중복_불가.getErrorMessage());
    }

    @Test
    void 구매한_로또와_당첨_번호간_3개_일치_테스트() {
        Lotto prizeLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 3, 4, 5, 6"));
        Lotto inputLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 3, 4, 24, 35, 45"));
        assertThat(inputLotto.findLottoMatchCount(prizeLotto)).isEqualTo(3);
    }

    @Test
    void 구매한_로또와_당첨_번호간_4개_일치_테스트() {
        Lotto prizeLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 3, 4, 5, 6"));
        Lotto inputLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 3, 4, 5, 35, 45"));
        assertThat(inputLotto.findLottoMatchCount(prizeLotto)).isEqualTo(4);
    }

    @Test
    void 로또_출력_테스트() {
        Lotto lotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 3, 4, 5, 6"));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
