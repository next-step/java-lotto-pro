package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    Lottos lottos;

    @BeforeEach
    void before() {
        lottos = new Lottos();
    }

    @Test
    void 로또_개수를_반환한다() {
        // when
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottos.add(Lotto.create(numbers));
        // then
        assertThat(lottos.count()).isEqualTo(1);
    }

}