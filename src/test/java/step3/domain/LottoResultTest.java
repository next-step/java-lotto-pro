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
        assertThat(lottoResult.rankingCount(Ranking.FIRST)).isZero();
    }

    @Test
    void 로또_별_당첨결과_반영() {
        lottoResult.updateHitRanking(Ranking.THIRD);
        assertThat(lottoResult.rankingCount(Ranking.THIRD)).isEqualTo(1);
    }

    @Test
    void 수익률_계산() {
        lottoResult.updateHitRanking(Ranking.FIFTH);
        double yield = lottoResult.calculateYield(10_000);
        assertThat(yield).isEqualTo(0.50);
    }
}
