package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.statistics.Rank;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BonusLottoNumberTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(7)
                )
        );
    }

    @Test
    @DisplayName("보너스 번호 일치여부를 확인한다.")
    void bonusLottoNumberIsMatchTrue() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertTrue(lotto.isMatchBonus(new BonusLottoNumber(new LottoNumber(7))));
    }

    @Test
    @DisplayName("5개 번호 일치, 보너스 볼이 일치하는 경우 2등을 리턴한다.")
    void getRankSecond() {
        Lotto lotto = new Lotto(lottoNumbers);
        Rank rank = lotto.getRank(new WinningLottoNumbers("1,2,3,4,5,6"), new BonusLottoNumber(new LottoNumber(7)));
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 번호만 일치하는 경우 3등을 리턴한다.")
    void getRankThird() {
        Lotto lotto = new Lotto(lottoNumbers);
        Rank rank = lotto.getRank(new WinningLottoNumbers("1,2,3,4,5,6"), new BonusLottoNumber(new LottoNumber(10)));
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}
