package lotto.View;

import lotto.view.ErrorMessage;
import lotto.view.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest {

    @DisplayName("정상 입력값 검증")
    @Test
    void nomalInput() {
        int price = InputHandler.price("14000");
        assertThat(price).isEqualTo(14);
    }

    @DisplayName("구입 금액을 문자로 입력할때 에러 검증")
    @Test
    void textPriceInputError() {
        assertThatThrownBy(() -> {
            InputHandler.price("만사천원");
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR);
    }

    @DisplayName("문자열을 나눠서 로또 int배열로 만드는 기능")
    @Test
    void splitTextToInts() {
        List<Integer> numbers = InputHandler.splitTextToInts("1, 2, 3, 4, 5, 6");

        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("문자열 구분자를 잘못 넣었을때 에러")
    @Test
    void splitError() {
        assertThatThrownBy(() -> {
            InputHandler.splitTextToInts("1. 2. 3. 4. 5. 6");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SPLITED_ERROR);
    }

    @DisplayName("당첨 로또 숫자가 범위를 벗어났을때 에러")
    @Test
    void rangeOverError() {
        assertThatThrownBy(() -> {
            InputHandler.splitTextToInts("0, 1, 2, 3, 4, 46");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SPLITED_ERROR);
    }

    @DisplayName("구매가능한 로또수와 수동으로 구매할 로또 수 입력 검증")
    @Test
    void buyManualLotto() {
        int manualLottoCount = InputHandler.buyManualLotto("5", 11);
        assertThat(manualLottoCount).isEqualTo(5);

        manualLottoCount = InputHandler.buyManualLotto("10", 10);
        assertThat(manualLottoCount).isEqualTo(10);
    }

    @DisplayName("수동으로 구매할 로또 수가 구매가능한 로또수 보다 클때 에러 검증")
    @Test
    void buyManualLottoOverError() {
        assertThatThrownBy(() -> {
            InputHandler.buyManualLotto("10", 9);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LACK_OF_MONEY);
    }
}
