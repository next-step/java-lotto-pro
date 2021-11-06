package lotto.util;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest {

    @DisplayName("정상 입력값 검증")
    @Test
    void nomalInput() {
        int price = InputHandler.price("14000");
        assertThat(price).isEqualTo(14);
    }

    @DisplayName("로또 99개 이상 사려고 할때 에러 검증")
    @Test
    void wrongInputError() {
        assertThatThrownBy(()->{
            InputHandler.price("1000000");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_MAX_BUY_ERROR);
    }

    @DisplayName("구입 금액을 문자로 입력할때 에러 검증")
    @Test
    void textPriceInputError() {
        assertThatThrownBy(()->{
            InputHandler.price("만사천원");
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR);
    }
}
