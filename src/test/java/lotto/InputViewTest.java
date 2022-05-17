package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.ui.InputView;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    public void 구입금액_입력값_숫자아님() {
        assertThatThrownBy(() -> InputView.validateMoneyInput("14000s"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구입금액_입력값_음수() {
        assertThatThrownBy(() -> InputView.validateMoneyInput("-23000"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구입금액_숫자_아님_예외처리() {
        assertThatThrownBy(() -> InputView.validateMoneyInput("NotNumber")).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구입금액_음수_예외처리_확인() {
        assertThatThrownBy(() -> InputView.validateMoneyInput("-10000")).isInstanceOf(RuntimeException.class);
    }
}
