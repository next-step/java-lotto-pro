package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeExchangerTest {
    private static Winners prizes;

    @BeforeAll
    static void beforeAll() {
        prizes = new Winners(Arrays.asList(Prize.FIRST_PLACE, Prize.FIRST_PLACE, Prize.SECOND_PLACE));
    }

    @Test
    @DisplayName("로또 당첨금 총액 확인")
    void get_total_lotto_prize_test() {
        PrizeExchanger prizeExchanger = PrizeExchanger.getInstance();
        long prize = prizeExchanger.exchange(prizes);
        assertThat(prize).isEqualTo(4001500000L);
    }
}
