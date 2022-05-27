package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import org.junit.jupiter.api.Test;

public class LottoTest {

    static class TestLotto extends Lotto {
        TestLotto(List<Integer> lottoNos) {
            for (Integer lottoNo : lottoNos) {
                addLottoNumber(new LottoNo(lottoNo));
            }
        }
    }

    @Test
    public void 로또_자동_생성_리스트() {
        Lotto lotto = RandomUtils.createRandomLotto();
        List<LottoNo> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    public void 당첨번호_일치개수_구하기() {
        Lotto lotto = new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new TestLotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(lotto1.checkMatchCount(lotto)).isEqualTo(3);
    }

    @Test
    public void 보너스_확인() {
        Lotto lotto = new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkBonusMatch(new LottoNo(6))).isTrue();
    }

    @Test
    public void 보너스_당첨번호_중복성검사() {
        assertThatThrownBy(
                () -> new LottoNo(6).validateBonus(new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}))).isInstanceOf(
                IllegalArgumentException.class);
    }
}
