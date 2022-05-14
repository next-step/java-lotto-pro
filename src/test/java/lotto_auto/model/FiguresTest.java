package lotto_auto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class FiguresTest {
    @Test
    void 당첨_통계_결과_테스트() {
        Lottos lottos = new Lottos(Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
        Lotto winning = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Figures figures = new Figures(lottos, winning);

        assertThat(figures.toString())
                .isEqualTo("3개 일치 (5000원)- 0개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "6개 일치 (2000000000원)- 1개\n");
    }
}
