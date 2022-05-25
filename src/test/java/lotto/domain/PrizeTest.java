package lotto.domain;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    private static WinningNumbers answerLotto;

    @BeforeAll
    static void beforeAll() {
        Lotto winner = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        answerLotto = new WinningNumbers(winner, LottoNumber.of(8));
    }

    @Test
    @DisplayName("1등 당첨 테스트")
    void get_first_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        Prize prize = Prize.matchLotto(lotto, answerLotto);

        assertThat(prize).isEqualTo(Prize.FIRST_PLACE);
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void get_second_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7)));
        Prize prize = Prize.matchLotto(lotto, answerLotto);

        assertThat(prize).isEqualTo(Prize.SECOND_PLACE);
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    void get_third_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(7), LottoNumber.of(8)));
        Prize prize = Prize.matchLotto(lotto, answerLotto);

        assertThat(prize).isEqualTo(Prize.THIRD_PLACE);
    }

    @Test
    @DisplayName("4등 당첨 테스트")
    void get_fourth_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9)));
        Prize prize = Prize.matchLotto(lotto, answerLotto);

        assertThat(prize).isEqualTo(Prize.FOURTH_PLACE);
    }

    @ParameterizedTest
    @MethodSource("fail_lottoes")
    @DisplayName("미 당첨 테스트")
    void get_none_prize_test(Lotto lotto, Prize prize) {
        assertThat(Prize.matchLotto(lotto, answerLotto)).isEqualTo(prize);
    }

    static Stream<Arguments> fail_lottoes() {
        return Stream.of(
                Arguments.of(new Lotto("45, 44, 43, 42, 41, 40"), Prize.FAIL),
                Arguments.of(new Lotto("1, 44, 43, 42, 41, 40"), Prize.FAIL),
                Arguments.of(new Lotto("1, 2, 43, 42, 41, 40"), Prize.FAIL)
        );
    }

    @Test
    @DisplayName("보너스 당첨 테스트")
    void get_bounus_prize_test() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 8");
    }

}

