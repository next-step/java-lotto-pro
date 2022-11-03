package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.vo.Lotto;
import lotto.model.vo.LottoNumber;
import lotto.model.vo.PurchaseCount;
import lotto.model.vo.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRunTest {

    @DisplayName("구매 개수 계산 확인")
    @Test
    void 로또_구매_개수() {
        long buyAmount = 14000;
        PurchaseCount expected = new PurchaseCount(14);
        assertThat(LottoRun.getPurchaseCount(buyAmount)).isEqualTo(expected);
    }

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

        assertThat(LottoRun.countMatchNumber(winLotto, userLotto)).isEqualTo(expected);
    }

    @DisplayName("수익률 계산")
    @Test
    void 수익률_계산() {
        long buyAmount = 14000;
        long winAmount = 5000;
        double expected = 0.35;
        assertThat(LottoRun.calculateProfit(buyAmount, winAmount)).isEqualTo(expected);
    }

}
