package lotto_auto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FiguresTest {
    private Figures figures;
    @BeforeEach
    void setUp() {
        Map<LottoRank, Integer> tmp = new HashMap<>();
        tmp.put(LottoRank.FIRST, 1);
        figures = new Figures(tmp);
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
