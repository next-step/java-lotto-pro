package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningsTest {
    Winnings winnings;

    @BeforeEach
    void setUp() {
        final List<Winning> data = new ArrayList<>();
        data.add(Winning.THIRD_PRIZE);
        data.add(Winning.SECOND_PRIZE);
        data.add(Winning.SECOND_PRIZE);
        data.add(Winning.NONE);
        winnings = new Winnings(data);
    }

    @Test
    void size() {
        assertThat(winnings.size()).isEqualTo(4);
    }

    @Test
    void getReturnOnInvestment() {
        assertThat(winnings.getReturnOnInvestment(new Money(4000)))
                .isEqualTo((double)(50_000 + 1_500_000 * 2)/(4000));
    }
}
