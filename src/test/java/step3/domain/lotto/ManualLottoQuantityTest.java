package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.type.ErrorMessageType.INPUT_NOT_ALLOW_NEGATIVE_NUMBER;

class ManualLottoQuantityTest {

    @Test
    @DisplayName("수량에 음수는 입력할 수 없습니다.")
    void notAllowNegativeNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ManualLottoQuantity(-1))
                .withMessageContaining(INPUT_NOT_ALLOW_NEGATIVE_NUMBER.getMessage());
    }
}
