package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

    @DisplayName("당첨번호 대비 일치 개수 확인")
    @Test
    void 일치_개수_확인() {
        Lotto lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumber(1));
        lotto.addLottoNumber(new LottoNumber(2));
        lotto.addLottoNumber(new LottoNumber(3));
        lotto.addLottoNumber(new LottoNumber(4));
        lotto.addLottoNumber(new LottoNumber(5));
        lotto.addLottoNumber(new LottoNumber(6));
        WinLotto winLotto = new WinLotto(lotto);
        Lotto userLotto = new Lotto();
        userLotto.addLottoNumber(new LottoNumber(1));
        userLotto.addLottoNumber(new LottoNumber(2));
        userLotto.addLottoNumber(new LottoNumber(3));
        userLotto.addLottoNumber(new LottoNumber(7));
        userLotto.addLottoNumber(new LottoNumber(8));
        userLotto.addLottoNumber(new LottoNumber(9));

        int expected = 3;

        assertThat(winLotto.compareWithLotto(userLotto)).isEqualTo(expected);
    }
}
