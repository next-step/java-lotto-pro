package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStoreTest {
    @DisplayName("가격은 음수가 아니어야 함.")
    @Test
    void 가격은_음수가_아니어야_함() {
        final int lottoUnitPrice = -100;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoStore(lottoUnitPrice))
                .withMessageContaining("금액은 음수가 아니어야 합니다.");
    }

    @DisplayName("가격은 0이 아니어야 함.")
    @Test
    void 가격은_0원이_아니어야_함() {
        final int lottoUnitPrice = 0;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoStore(lottoUnitPrice))
                .withMessageContaining("가격은 0 이상이어야 합니다.");
    }

    @DisplayName("로또 판매점 생성")
    @Test
    void 로또판매점_생성() {
        final int lottoUnitPrice = 1000;

        assertThatNoException()
                .isThrownBy(() -> new LottoStore(lottoUnitPrice));
    }

    @DisplayName("주어진 금액으로 살 수 있는 최대한의 로또를 구매할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "10000, 10",
            "0, 0",
            "1500, 1"
    })
    void 로또_구매(final int givenMoney, final int expectedCount) {
        final LottoStore store = new LottoStore(1000);
        final Money money = new Money(givenMoney);

        final List<Lotto> lottos = store.buyLottos(money, Fixture.pick123456());

        Assertions.assertThat(lottos).hasSize(expectedCount);
    }
}
