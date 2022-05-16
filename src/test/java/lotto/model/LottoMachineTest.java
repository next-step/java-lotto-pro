package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("로또 가격보다 작은 값을 입력받으면 IllegalArgumentException이 발생")
    void inputValueLessThanLottoPrice() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine("900"))
                .withMessage("로또 한 장의 금액보다 입력한 금액이 적습니다.");
    }
}
