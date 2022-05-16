package lotto_auto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FiguresTest {
    private Figures figures;
    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6));
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new LottoNumbers(lottoNumberList))));
        Lotto winning = new Lotto(new LottoNumbers(lottoNumberList));
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
