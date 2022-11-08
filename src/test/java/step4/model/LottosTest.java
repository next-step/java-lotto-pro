package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    private void setUp() {
        lottos = new Lottos();
        lottos.add(new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList())));
        lottos.add(new Lotto(Stream.of(20,30,32,40,42,43)
                .map(LottoNumber::new)
                .collect(Collectors.toList())));
    }

    @Test
    @DisplayName("로또목록이 비어있다면 로또개수는 0을 리턴한다.")
    void whenCount_thenNumber() {
        Lottos emptyLottos = new Lottos();

        assertThat(emptyLottos.count()).isZero();
    }

    @Test
    @DisplayName("로또목록이 2개 채워져있다면 로또개수는 2개를 리턴한다.")
    void givenFillOutTwoElements_whenCount_thenNumberTwo() {
        assertThat(lottos.count()).isEqualTo(2);
    }
}
