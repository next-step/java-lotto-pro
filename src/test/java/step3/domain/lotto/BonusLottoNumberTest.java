package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.factory.Manual;
import step3.domain.statistics.Rank;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BonusLottoNumberTest {

    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
    }

    @Test
    @DisplayName("보너스 번호 일치여부를 확인한다.")
    void bonusLottoNumberIsMatchTrue() {
        Lotto lotto = new Lotto(new Manual(lottoNumbers));
        assertTrue(lotto.isMatchBonus(new BonusLottoNumber(LottoNumber.of(7))));
    }

    @Test
    @DisplayName("5개 번호 일치, 보너스 볼이 일치하는 경우 2등을 리턴한다.")
    void getRankSecond() {
        Lotto lotto = new Lotto(new Manual(lottoNumbers));
        Rank rank = lotto.getRank(new WinningLottoNumbers("1,2,3,4,5,6"), new BonusLottoNumber(LottoNumber.of(7)));
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 번호만 일치하는 경우 3등을 리턴한다.")
    void getRankThird() {
        Lotto lotto = new Lotto(new Manual(lottoNumbers));
        Rank rank = lotto.getRank(new WinningLottoNumbers("1,2,3,4,5,6"), new BonusLottoNumber(LottoNumber.of(10)));
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}
