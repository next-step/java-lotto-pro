package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottoTest {

    static Lotto lotto;

    static class TestLotto extends Lotto {
        TestLotto(List<Integer> lottoNos) {
            for (Integer lottoNo : lottoNos) {
                addLottoNumber(new LottoNo(lottoNo));
            }
        }
    }

    @BeforeAll
    static void beforeAll() {
        lotto = new TestLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_자동_생성_리스트() {
        Lotto lotto = RandomUtils.createRandomLotto();
        List<LottoNo> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 당첨번호_일치개수_구하기() {
        Lotto lotto1 = new TestLotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(lotto1.checkMatchCount(lotto)).isEqualTo(3);
    }

    @Test
    void 보너스_확인() {
        assertThat(lotto.checkBonusMatch(new LottoNo(6))).isTrue();
    }

    @Test
    void 보너스_당첨번호_중복성검사() {
        assertThatThrownBy(
                () -> new LottoNo(6).validateBonus(lotto)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 로또_중복_숫자등록() {
        Lotto lottoDuplicate = new Lotto();
        lottoDuplicate.addLottoNumber(new LottoNo(1));
        lottoDuplicate.addLottoNumber(new LottoNo(2));

        assertThatThrownBy(
                () -> lottoDuplicate.addLottoNumber(new LottoNo(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
