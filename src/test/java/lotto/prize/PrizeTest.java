package lotto.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    @DisplayName("3개 일치하는 경우")
    void match_three_lotto_number() {
        Prize prize = Prize.prizeOf(3, false);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    @DisplayName("4개 일치하는 경우")
    void match_four_lotto_number() {
        Prize prize = Prize.prizeOf(4, false);
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @Test
    @DisplayName("5개 일치하는 경우")
    void match_five_lotto_number() {
        Prize prize = Prize.prizeOf(5, false);
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @Test
    @DisplayName("5개 일치하는 하면서 보너스 볼까지 일치하는 경우")
    void match_five_lotto_number_and_bonus_match() {
        Prize prize = Prize.prizeOf(5, true);
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    @DisplayName("6개 일치하는 경우")
    void match_six_lotto_number() {
        Prize prize = Prize.prizeOf(6, false);
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @Test
    @DisplayName("0개 일치하는 경우")
    void match_zero_lotto_number() {
        Prize prize = Prize.prizeOf(0, false);
        assertThat(prize).isEqualTo(Prize.MISS);
    }

}
