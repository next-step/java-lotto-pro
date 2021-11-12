package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoPurchaseMachineTest {

    private static List<List<Integer>> lottos = null;

    @BeforeEach
    void setUp() {
        lottos = Arrays.asList(
                Arrays.asList(1,2,3,4,5,6),
                Arrays.asList(10,20,30,40,41,44),
                Arrays.asList(18,20,23,25,32,33)
        );
    }

    @Test
    void buy_수동로또구매() throws IOException {
        ManualLottoPurchaseMachine manualLottoPurchaseMachine = ManualLottoPurchaseMachine.from(10, 3, lottos);
        assertThat(manualLottoPurchaseMachine.getManualLottoPurchaseSize()).isEqualTo(3);
    }

    @Test
    void buy_예외_구매금액보다_많은_수동_로또_생성() {
        assertThatThrownBy(()
                -> ManualLottoPurchaseMachine.from(10, 20, lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The purchase amount is insufficient.");
    }
}
