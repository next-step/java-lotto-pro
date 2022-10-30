package step3.domain.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.amount.Amount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;
import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

class InputAmountTest {

    @Test
    @DisplayName("빈 값을 입력하면 IllegalArgumentException이 발생한다.")
    void inputNotAllowBlank() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Input<Amount> input = new InputAmount();
                    input.create("");
                })
                .withMessageContaining(INPUT_NOT_ALLOW_BLANK.getMessage());
    }

    @Test
    @DisplayName("null을 입력하면 IllegalArgumentException이 발생한다.")
    void inputNotAllowNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Input<Amount> input = new InputAmount();
                    input.create(null);
                })
                .withMessageContaining(INPUT_NOT_ALLOW_BLANK.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"t", "+", "가"})
    @DisplayName("숫자를 제외한 문자를 입력하면 IllegalArgumentException이 발생한다.")
    void inputOnlyAllowNumber(String inputText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Input<Amount> input = new InputAmount();
                    input.create(inputText);
                })
                .withMessageContaining(INPUT_ONLY_ALLOW_NUMBER.getMessage());
    }

    @Test
    @DisplayName("유효한 값을 입력하면 구입 금액 객체가 생성된다.")
    void inputCreateSuccess() {
        Input<Amount> input = new InputAmount();
        Amount amount = input.create("1000");
        assertThat(amount).isEqualTo(new Amount(1000));
    }
}
