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
        final List<Winning> winnings = new ArrayList<>();
        winnings.add(Winning.FOURTH_PRIZE);
        winnings.add(Winning.THIRD_PRIZE);
        winnings.add(Winning.THIRD_PRIZE);
        winnings.add(Winning.NONE);
        this.lottoResult = new LottoResult(winnings);
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
