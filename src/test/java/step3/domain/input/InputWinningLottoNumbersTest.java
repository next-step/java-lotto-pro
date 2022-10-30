package step3.domain.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.WinningLottoNumbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;

class InputWinningLottoNumbersTest {

    @Test
    @DisplayName("빈 값을 입력하면 IllegalArgumentException이 발생한다.")
    void inputNotAllowBlank() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Input<WinningLottoNumbers> input = new InputWinningLottoNumbers();
                    input.create("");
                })
                .withMessageContaining(INPUT_NOT_ALLOW_BLANK.getMessage());
    }

    @Test
    @DisplayName("null을 입력하면 IllegalArgumentException이 발생한다.")
    void inputNotAllowNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Input<WinningLottoNumbers> input = new InputWinningLottoNumbers();
                    input.create(null);
                })
                .withMessageContaining(INPUT_NOT_ALLOW_BLANK.getMessage());
    }

    @Test
    @DisplayName("당첨 번호를 입력받아 당첨 로또 번호를 생성합니다.")
    void createWinningLottoNumbers() {
        Input<WinningLottoNumbers> inputWinningLottoNumber = new InputWinningLottoNumbers();
        WinningLottoNumbers winningLottoNumbers = inputWinningLottoNumber.create("1, 2, 3, 4, 5, 6");
        assertThat(winningLottoNumbers.getLottoNumbers())
                .containsExactly(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                );
    }
}
