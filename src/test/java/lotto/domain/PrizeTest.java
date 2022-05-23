package lotto.domain;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    private static Lotto answerLotto;

    @BeforeAll
    static void beforeAll() {
        answerLotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
    }

    @Test
    @DisplayName("1등 당첨 테스트")
    void get_first_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        Winners winners = Prize.matchLotto(Stream.of(lotto)
                .collect(Collectors.toList()), answerLotto);

        assertThat(winners.getWinners().get(0)).isEqualTo(Prize.FIRST_PLACE);
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void get_second_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7)));
        Winners winners = Prize.matchLotto(Stream.of(lotto)
                .collect(Collectors.toList()), answerLotto);

        assertThat(winners.getWinners().get(0)).isEqualTo(Prize.SECOND_PLACE);
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    void get_third_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(7), LottoNumber.of(8)));
        Winners winners = Prize.matchLotto(Stream.of(lotto)
                .collect(Collectors.toList()), answerLotto);

        assertThat(winners.getWinners().get(0)).isEqualTo(Prize.THIRD_PLACE);
    }

    @Test
    @DisplayName("4등 당첨 테스트")
    void get_fourth_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9)));
        Winners winners = Prize.matchLotto(Stream.of(lotto)
                .collect(Collectors.toList()), answerLotto);

        assertThat(winners.getWinners().get(0)).isEqualTo(Prize.FOURTH_PLACE);
    }

    @Test
    @DisplayName("미 당첨 테스트")
    void get_none_prize_test() {
        Lotto lotto = new Lotto("45, 44, 43, 42, 41, 40");
        Lotto lotto2 = new Lotto("1, 44, 43, 42, 41, 40");
        Lotto lotto3 = new Lotto("1, 2, 43, 42, 41, 40");


        Winners winners = Prize.matchLotto(Stream.of(lotto, lotto2, lotto3)
                .collect(Collectors.toList()), answerLotto);

        assertThat(winners.getWinners().get(0)).isEqualTo(Prize.FAIL);
        assertThat(winners.getWinners().get(1)).isEqualTo(Prize.FAIL);
        assertThat(winners.getWinners().get(2)).isEqualTo(Prize.FAIL);
    }

}
