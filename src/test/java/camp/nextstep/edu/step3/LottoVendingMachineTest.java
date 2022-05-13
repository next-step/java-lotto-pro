package camp.nextstep.edu.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class LottoVendingMachineTest {
    private final LottoGenerator generator = spy(new LottoGenerator());
    private LottoVendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new LottoVendingMachine(generator);
    }

    @DisplayName("1000원 단위로 Lotto 를 발급하고 LottoPaper 를 반환한다.")
    @Test
    void issuedTest() {
        vendingMachine.issued(14000);
        verify(generator).auto(14);
    }

    @DisplayName("지불금액이 1000원 보다 낮으면 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {900, 0, -100})
    void invalidInputTest(final int amount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> vendingMachine.issued(amount));
    }
}
