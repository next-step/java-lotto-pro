package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private List<Lotto> lottos;

    @BeforeEach
    void setup() {
        lottos = Arrays.asList(
                Lotto.from("1,2,3,4,5,6"),
                Lotto.from("1,2,3,4,5,10"),
                Lotto.from("1,2,3,4,5,10"),
                Lotto.from("1,2,3,4,10,11"),
                Lotto.from("1,2,3,4,10,11"),
                Lotto.from("1,2,3,10,11,12"),
                Lotto.from("1,2,3,10,11,12"),
                Lotto.from("1,10,11,12,13,14"),
                Lotto.from("1,10,11,12,13,14"),
                Lotto.from("10,11,12,13,14,15")
        );
    }


    @DisplayName("로또의 개수를 구한다.")
    @Test
    void count() {
        assertThat(Lottos.from(lottos).count()).isEqualTo(10);
    }

    @DisplayName("로또들과 로또의 로또숫자를 비교해서 같은 로또숫자의 개수들을 구한다.")
    @Test
    void getMatchingCounts() {
        Lotto lotto = Lotto.from("1,2,3,4,5,6");
        List<Integer> matchingCounts = new ArrayList<>(Arrays.asList(6, 5, 5, 4, 4, 3, 3, 1, 1, 0));

        assertThat(Lottos.from(lottos).getMatchingCounts(lotto)).isEqualTo(matchingCounts);
    }

}
