package lotto.view;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import lotto.model.Payment;
import lotto.util.Console;

public class InputViewTest {
    @ParameterizedTest
    @DisplayName("1000미만이거나 1000으로 나누어 떨어지지 않거나 숫자가 아닌 입력값이 들어올 때 예외 발생")
    @ValueSource(strings = {"1q2w3e4r!", "999", "1001"})
    void readPaymentByInvalidInput(String payment) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(InputView::readPayment),
            payment
        );
    }

    @ParameterizedTest
    @DisplayName("입력값이 음수이거나, 구입금액으로 살 수 있는 로또 수의 최댓값을 초과하거나, 숫자가 아닐 경우, 예외를 발생")
    @ValueSource(strings = {"a", "-1", "15"})
    void readLottoCountByInvalidInput(String manualLottoCount) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(() -> InputView.readLottoCount(new Payment(14000))),
            manualLottoCount
        );
    }

    @ParameterizedTest
    @DisplayName("입력값이 ','을 구분자로 하는 1~45까지의 중복되지 않는 숫자 6개로 이루어진 문자열이 아닐 경우 예외 발생")
    @ValueSource(strings = {"1q2w3e4r!", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,1,2,3,4,5", "1,2,3,4,5,46", "0,1,2,3,4,5"})
    void readManualLottosByInvalidInput(String numbers) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(() -> InputView.readManualLottos(1)),
            numbers
        );
    }

    @Test
    @DisplayName("수동으로 구매할 로또의 수가 0일 때, 반환값이 비어있는지 테스트")
    void readManualLottosByZeroCount() {
        assertThat(InputView.readManualLottos(0).isEmpty()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("입력값이 ','을 구분자로 하는 1~45까지의 중복되지 않는 숫자 6개로 이루어진 문자열이 아닐 경우 예외 발생")
    @ValueSource(strings = {"1q2w3e4r!", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,1,2,3,4,5", "1,2,3,4,5,46", "0,1,2,3,4,5"})
    void readWinningLottoByInvalidInput(String winningNumbers) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(InputView::readWinningLotto),
            winningNumbers
        );
    }

    @ParameterizedTest
    @DisplayName("입력값이 1~45 사이의 숫자가 아닐 경우 예외 발생")
    @ValueSource(strings = {"1q2w3e4r!", "0", "46"})
    void readBonusNumberByInvalidInput(String bonusNumber) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(InputView::readBonusNumber),
            bonusNumber
        );
    }

    private void assertTestWithMockedInput(Executable executable, String input) {
        try (final MockedStatic<Console> inputView = mockStatic(Console.class)) {
            inputView.when(Console::readLine)
                .thenReturn(input);
            executable.execute();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
