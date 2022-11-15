package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.exception.LottoInvalidSizeException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 로또_생성하기() {
        assertThatNoException().isThrownBy(() ->
                new Lotto(Arrays.asList(
                        new LottoNumber(1)
                        , new LottoNumber(2)
                        , new LottoNumber(3)
                        , new LottoNumber(4)
                        , new LottoNumber(5)
                        , new LottoNumber(6))));
    }

    @Test
    void 로또_생성하기_예외() {
        assertThatThrownBy(() ->
                new Lotto(Arrays.asList(
                        new LottoNumber(1)
                        , new LottoNumber(2)
                        , new LottoNumber(3)
                        , new LottoNumber(4)
                        , new LottoNumber(6))))
                .isInstanceOf(LottoInvalidSizeException.class);
    }

    @Test
    void 로또_비교해서_일치하는_갯수_구하기() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        WinningLotto winLotto = new WinningLotto(new Lotto("1, 2, 3, 7, 8, 9"), new LottoNumber("5"));

        int numberOfMatching = lotto.countNumberOfMatching(winLotto);

        assertThat(numberOfMatching).isEqualTo(3);
    }
}
