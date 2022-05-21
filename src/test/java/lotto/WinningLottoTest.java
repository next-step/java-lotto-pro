package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    public void createWinningLotto() {
        //given
        Lotto lotto = new Lotto(
            () -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        LottoNumber bonusLottoNumber = new LottoNumber(7);
        WinningLotto expectedWinningLotto = new WinningLotto(lotto, bonusLottoNumber);
        //when
        WinningLotto actualWinningLotto = new WinningLotto(lotto, bonusLottoNumber);
        //then
        assertThat(actualWinningLotto).isEqualTo(expectedWinningLotto);
    }

    @Test
    public void differentBonusNumber() {
        //given
        Lotto lotto = new Lotto(
            () -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        LottoNumber bonusLottoNumber = new LottoNumber(6);

        //when
        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusLottoNumber)).isInstanceOf(
            IllegalArgumentException.class);
    }


}
