package lotto.domain;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
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
    @DisplayName("1등 당첨금 반환 테스트")
    void get_first_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        List<Prize> prizes = Prize.matchLotto(Stream.of(lotto)
                .collect(Collectors.toList()), answerLotto);

        assertThat(prizes.get(0).getPrize()).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("2등 당첨금 반환 테스트")
    void get_second_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7)));
        List<Prize> prizes = Prize.matchLotto(Stream.of(lotto)
                .collect(Collectors.toList()), answerLotto);

        assertThat(prizes.get(0).getPrize()).isEqualTo(1500000);
    }

    @Test
    @DisplayName("3등 당첨금 반환 테스트")
    void get_third_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(7), LottoNumber.of(8)));
        List<Prize> prizes = Prize.matchLotto(Stream.of(lotto)
                .collect(Collectors.toList()), answerLotto);

        assertThat(prizes.get(0).getPrize()).isEqualTo(50000);
    }

    @Test
    @DisplayName("4등 당첨금 반환 테스트")
    void get_fourth_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9)));
        List<Prize> prizes = Prize.matchLotto(Stream.of(lotto)
                .collect(Collectors.toList()), answerLotto);

        assertThat(prizes.get(0).getPrize()).isEqualTo(5000);
    }

    @Test
    @DisplayName("당첨 안됨 테스트")
    void get_none_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(45), LottoNumber.of(44), LottoNumber.of(43)
                , LottoNumber.of(42), LottoNumber.of(41), LottoNumber.of(40)));
        Lotto lotto2 = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(44), LottoNumber.of(43)
                , LottoNumber.of(42), LottoNumber.of(41), LottoNumber.of(40)));
        Lotto lotto3 = new Lotto(Arrays.asList(LottoNumber.of(45), LottoNumber.of(2), LottoNumber.of(43)
                , LottoNumber.of(42), LottoNumber.of(41), LottoNumber.of(40)));


        List<Prize> prizes = Prize.matchLotto(Stream.of(lotto, lotto2, lotto3)
                .collect(Collectors.toList()), answerLotto);

        assertThat(prizes.get(0).getPrize()).isEqualTo(0);
        assertThat(prizes.get(1).getPrize()).isEqualTo(0);
        assertThat(prizes.get(2).getPrize()).isEqualTo(0);
    }

}
