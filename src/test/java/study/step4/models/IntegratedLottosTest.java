package study.step4.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class IntegratedLottosTest {
    @Test
    void 당첨_확인하기() {
        WinningLotto winLottoNumbers = new WinningLotto(new Lotto("4, 5, 6, 7, 8, 9"), new LottoNumber("3"));
        Lottos autoLottos = new Lottos(Arrays.asList(new Lotto("1, 2, 3, 4, 5, 6")
                , new Lotto("2, 3, 4, 5, 6, 7")
                , new Lotto("2, 4, 5, 6, 7, 8")
                , new Lotto("4, 5, 6, 7, 10, 11")
                , new Lotto("3, 4, 5, 6, 7, 8")));
        Lottos manualLottos = new Lottos(Arrays.asList(new Lotto("11, 12, 13, 14, 15, 16")
                , new Lotto("12, 13, 14, 15, 16, 17")));
        IntegratedLottos integratedLottos = new IntegratedLottos(manualLottos, autoLottos);

        Winners winners = new Winners(integratedLottos.findWinningLottos(winLottoNumbers));

        // 4, 5, 6
        assertThat(winners.numberOfRankers(Rank.FIFTH)).isEqualTo(1);
        // 4, 5, 6, 7
        assertThat(winners.numberOfRankers(Rank.FOURTH)).isEqualTo(2);
        // 4, 5, 6, 7, 8
        assertThat(winners.numberOfRankers(Rank.THIRD)).isEqualTo(1);
        // 4, 5, 6, 7, 8 bonus 3
        assertThat(winners.numberOfRankers(Rank.SECOND)).isEqualTo(1);
    }
}
