package lotto.view;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import lotto.util.Console;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"1q2w3e4r!", "999", "1001"})
    void readPaymentByInvalidInput(String payment) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(InputView::readPayment),
            payment
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "-1"})
    void readManualLottoCountByInvalidInput(String manualLottoCount) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(InputView::readManualLottoCount),
            manualLottoCount
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1q2w3e4r!", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46", "0,1,2,3,4,5"})
    void readManualLottosByInvalidInput(String numbers) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(() -> InputView.readManualLottos(1)),
            numbers
        );
    }

    @Test
    void readManualLottosByZeroCount() {
        assertThat(InputView.readManualLottos(0)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1q2w3e4r!", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46", "0,1,2,3,4,5"})
    void readWinningLottoByInvalidInput(String winningNumbers) {
        assertTestWithMockedInput(
            () -> assertThatIllegalArgumentException().isThrownBy(InputView::readWinningLotto),
            winningNumbers
        );
    }

    @ParameterizedTest
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
