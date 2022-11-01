package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기")
class StringCalculatorTest {

    @DisplayName("공백 또는 null 을 입력할 경우 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String text) {
        Delimiters delimiters = new Delimiters(text);
        String[] splitText = new StringCalculator(text, delimiters.delimiter()).split();
        assertThat(new Numbers(splitText).sum()).isEqualTo(0);
    }

    @DisplayName("숫자하나 입력하면 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void splitAndSum_숫자하나(String text) {
        Delimiters delimiters = new Delimiters(text);
        String[] splitText = new StringCalculator(text, delimiters.delimiter()).split();
        assertThat(new Numbers(splitText).sum()).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void splitAndSum_쉼표구분자(String text) {
        Delimiters delimiters = new Delimiters(text);
        String[] splitText = new StringCalculator(text, delimiters.delimiter()).split();
        assertThat(new Numbers(splitText).sum()).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    void splitAndSum_쉼표_또는_콜론_구분자(String text) {
        Delimiters delimiters = new Delimiters(text);
        String[] splitText = new StringCalculator(text, delimiters.delimiter()).split();
        assertThat(new Numbers(splitText).sum()).isEqualTo(6);
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    void splitAndSum_custom_구분자(String text) {
        Delimiters delimiters = new Delimiters(text);
        String[] splitText = new StringCalculator(text, delimiters.delimiter()).split();
        assertThat(new Numbers(splitText).sum()).isEqualTo(6);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3"})
    void splitAndSum_negative(String text) {
        Delimiters delimiters = new Delimiters(text);
        String[] splitText = new StringCalculator(text, delimiters.delimiter()).split();
        assertThatThrownBy(() -> new Numbers(splitText).sum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:a", "b", "3:c"})
    void splitAndSum_not_number(String text) {
        Delimiters delimiters = new Delimiters(text);
        String[] splitText = new StringCalculator(text, delimiters.delimiter()).split();
        assertThatThrownBy(() -> new Numbers(splitText).sum())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
