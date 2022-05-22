package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.generator.InputLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {
    @DisplayName("로또들 Random 구매 이후 로또들 사이즈 테스트")
    @Test
    void lottosPurchaseRandomSize() {
        Lottos lottos = Lottos.purchase(Money.valueOf(3333));
        assertThat(lottos.readOnlyLottos()).hasSize(3);
    }

    @DisplayName("로또 랭킹에 따른 상금(돈) 테스트")
    @ParameterizedTest(name = "로또 랭킹 {0} 에 따른 상금(돈) {1} 테스트")
    @CsvSource(value = {"3, 3333, 3", "4, 5000, 5", "0, 10000, 10"})
    void lottosPurchaseRandomAndManualSize(int count, int money, int expect) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottos.add(Lotto.draw(new InputLottoNumberGenerator("1, 2, 3, 4, 5, 7")));
        }
        Lottos lottos = Lottos.purchase(Money.valueOf(money), manualLottos);
        assertThat(lottos.readOnlyLottos()).hasSize(expect);
    }

    @DisplayName("로또들은 구입할 때 사용한 총 금액을 반환")
    @Test
    void lottosTotalPrice() {
        Lottos lottos = Lottos.purchase(Money.valueOf(3333));
        assertThat(lottos.totalPrice()).isEqualTo(Money.valueOf(3000));
    }
}
