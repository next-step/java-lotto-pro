package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        final List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FOURTH_PRIZE);
        ranks.add(Rank.THIRD_PRIZE);
        ranks.add(Rank.THIRD_PRIZE);
        ranks.add(Rank.NONE);
        this.lottoResult = new LottoResult(ranks);
    }

    @Test
    void size() {
        assertThat(lottoResult.size()).isEqualTo(4);
    }

    @Test
    void getReturnOnInvestment() {
        assertThat(lottoResult.getReturnOnInvestment(new Money(4000)))
                .isEqualTo((double)(50_000 + 1_500_000 * 2)/(4000));
    }
}
