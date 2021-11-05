package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottosTest {

    @DisplayName("로또를 여러장 구매하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    public void 로또구매_확인(int quantity) {
        assertThat(new Lottos(quantity).getSize()).isEqualTo(quantity);
    }

}
