package lotto.View;

import lotto.view.ErrorMessage;
import lotto.view.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest {

    @DisplayName("구입 금액을 문자로 입력할때 에러 검증")
    @Test
    void textPriceInputError() {
        assertThatThrownBy(() -> {
            InputHandler.validStringToInt("만사천원");
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR);
    }

    @DisplayName("문자열을 나눠서 로또 int배열로 만드는 기능")
    @Test
    void splitTextToInts() {
        List<Integer> numbers = InputHandler.splitTextToInts("1, 2, 3, 4, 5, 6");

        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 문자로 잘못 넣었을때 에러")
    @Test
    void splitError() {
        assertThatThrownBy(() -> {
            InputHandler.splitTextToInts("일, 이, 삼, 사, 오, 육");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SPLITED_ERROR);
    }
}
