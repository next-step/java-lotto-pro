package lotto_auto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FiguresTest {
    private Figures figures;
    @BeforeEach
    void setUp() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"))));
        Lotto winning = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"));
        figures = new Figures(lottos, winning);
    }
    @Test
    void 당첨_통계_결과_테스트() {
        assertAll(
            () -> assertThat(figures.getCountBy(LottoRank.FIRST)).isEqualTo(1),
            ()-> assertThat(figures.getCountBy(LottoRank.SECOND)).isEqualTo(0),
            ()-> assertThat(figures.getCountBy(LottoRank.THIRD)).isEqualTo(0),
            ()-> assertThat(figures.getCountBy(LottoRank.FOURTH)).isEqualTo(0)
        );
    }

    @Test
    void 수익금_결과_테스트() {
        assertThat(figures.getTotalWinning()).isEqualTo(LottoRank.FIRST.winnings());
    }
}
