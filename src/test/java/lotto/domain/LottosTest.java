package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("로또의 개수를 구한다.")
    @Test
    void count() {
        List<Lotto> lottos = Arrays.asList(
                Lotto.from("1,2,3,4,5,6"),
                Lotto.from("7,8,9,10,11,12")
        );

        assertThat(Lottos.from(lottos).count()).isEqualTo(2);
    }

}
