package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.utils.TestNumberProvider;

public class LottoStoreTest {

    private static List<UniqueNumbers> manualNumbersList;

    @BeforeAll
    public static void init() {
        manualNumbersList = TestNumberProvider.randomUniqueNumbersList(2);
    }

    @Test
    @DisplayName("가진 금액만큼 로또 구입")
    public void testSellOnlyAuto() {
        LottoStore store = new LottoStore();
        Money payment = Money.generate(1000);
        Lottos lottos = store.sell(payment);
        assertThat(lottos).isNotNull();
    }

    @Test
    @DisplayName("일부 로또 수동 구입")
    public void testSellWithManual() {
        LottoStore store = new LottoStore();
        Money payment = Money.generate(10000);
        Lottos lottos = store.sell(payment, manualNumbersList);
        assertThat(lottos).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("로또 구입시 금액 부족 Exception 발생")
    public void testValidate(int money, List<UniqueNumbers> numbersList) {
        Money payment = Money.generate(money);
        assertThatThrownBy(() -> {
            new LottoStore().sell(payment, numbersList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You don't have enough money.");
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(0, Collections.emptyList()),
                Arguments.of(1000, manualNumbersList)
        );
    }
}
