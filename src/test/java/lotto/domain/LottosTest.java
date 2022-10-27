package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @DisplayName("입력한 수 만큼 자동로또를 구매할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void lottos_size(int count) {

        Lottos lottos = new Lottos();
        lottos.buyRandomNumberLottos(count);

        assertThat(lottos.getLottosSize()).isEqualTo(count);
        System.out.println(lottos);
    }
}
