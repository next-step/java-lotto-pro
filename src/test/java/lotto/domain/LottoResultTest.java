package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(7, 1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 1등 테스트")
    @Test
    void firstPlace() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        // when
        LottoResult lottoResult = new LottoResult(winningLotto, Collections.singletonList(lotto));

        // then
        assertThat(lottoResult.getPrizeCount(LottoPrize.FIRST_PLACE)).isOne();
    }

    @DisplayName("로또 2등 테스트")
    @Test
    void secondPlace() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 7);

        // when
        LottoResult lottoResult = new LottoResult(winningLotto, Collections.singletonList(lotto));

        // then
        assertThat(lottoResult.getPrizeCount(LottoPrize.SECOND_PLACE)).isOne();
    }

    @DisplayName("로또 3등 테스트")
    @Test
    void thirdPlace() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 10);

        // when
        LottoResult lottoResult = new LottoResult(winningLotto, Collections.singletonList(lotto));

        // then
        assertThat(lottoResult.getPrizeCount(LottoPrize.THIRD_PLACE)).isOne();
    }

    @DisplayName("로또 4등 테스트")
    @Test
    void fourth_Place() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 10, 11);

        // when
        LottoResult lottoResult = new LottoResult(winningLotto, Collections.singletonList(lotto));

        // then
        assertThat(lottoResult.getPrizeCount(LottoPrize.FOURTH_PLACE)).isOne();
    }

    @DisplayName("로또 5등 테스트")
    @Test
    void lottoResult_firstPlace() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 10, 11, 12);

        // when
        LottoResult lottoResult = new LottoResult(winningLotto, Collections.singletonList(lotto));

        // then
        assertThat(lottoResult.getPrizeCount(LottoPrize.FIFTH_PLACE)).isOne();
    }

    @DisplayName("로또 수익률 테스트")
    @Test
    void earningsRate() {
        // given
        List<Lotto> lottoList = new ArrayList<Lotto>() {
            {
                add(new Lotto(8, 21, 23, 41, 42, 43));
                add(new Lotto(3, 5, 11, 16, 32, 38));
                add(new Lotto(7, 11, 16, 35, 36, 44));
                add(new Lotto(1, 8, 11, 31, 41, 42));
                add(new Lotto(13, 14, 16, 38, 42, 45));
                add(new Lotto(7, 11, 30, 40, 42, 43));
                add(new Lotto(2, 13, 22, 32, 38, 45));
                add(new Lotto(23, 25, 33, 36, 39, 41));
                add(new Lotto(1, 3, 5, 14, 22, 45));
                add(new Lotto(5, 9, 38, 41, 43, 44));
                add(new Lotto(2, 8, 9, 18, 19, 21));
                add(new Lotto(13, 14, 18, 21, 23, 35));
                add(new Lotto(17, 21, 29, 37, 42, 45));
                add(new Lotto(3, 8, 27, 30, 35, 44));
            }
        };

        // when
        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);

        // then
        assertThat(lottoResult.getEarningsRate()).isEqualTo(0.35);
    }
}
