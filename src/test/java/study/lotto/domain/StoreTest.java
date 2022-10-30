package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("로또를 구매하는 클래스 테스트")
class StoreTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 5, 10, 20, 50 })
    void 입력된_숫자만큼_로또를_구매하는_기능_테스트(int quantity) {
        List<Lotto> lottos = Store.buy(quantity);

        assertThat(lottos).hasSize(quantity);
    }
}
