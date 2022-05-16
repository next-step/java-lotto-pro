package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void beforeEach() {
        lottoResult = new LottoResult();
    }

    @Test
    void 순위별_당첨횟수_확인() {
        assertThat(lottoResult.rankingCount(Ranking.FIRST)).isEqualTo(0);
    }

    @Test
    void 로또_별_당첨결과_반영() {
        lottoResult.update(Ranking.THIRD);
        assertThat(lottoResult.rankingCount(Ranking.THIRD)).isEqualTo(1);
    }

    @Test
    void 수익률_계산() {
        lottoResult.update(Ranking.FIFTH);
        lottoResult.calculateYield(10_000);
        assertThat(lottoResult.getYield()).isEqualTo(0.50);
    }
}
