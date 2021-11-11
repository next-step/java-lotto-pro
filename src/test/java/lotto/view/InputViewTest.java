package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"1q2w3e4r!", "999", "1001"})
    void readPaymentByInvalidInput(String payment) {
        setInputToReader(payment);
        assertThatIllegalArgumentException().isThrownBy(InputView::readPayment);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1q2w3e4r!", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46", "0,1,2,3,4,5"})
    void readWinningLottoByInvalidInput(String winningNumbers) {
        setInputToReader(winningNumbers);
        assertThatIllegalArgumentException().isThrownBy(InputView::readWinningLotto);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1q2w3e4r!", "0", "46"})
    void readBonusNumber(String bonusNumber) {
        setInputToReader(bonusNumber);
        assertThatIllegalArgumentException().isThrownBy(InputView::readBonusNumber);
    }

    private void setInputToReader(String input) {
        byte[] inputBytes = (input + System.lineSeparator()).getBytes();
        System.setIn(new ByteArrayInputStream(inputBytes));
        InputView.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
}
