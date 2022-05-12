package lottoauto.wrapper;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;


class PriceTest {
    Price price = new Price();

    @Test
    void 숫자가_아닌_입력() {
        assertThatThrownBy(() -> price.setInput("test")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 입력_없음() {
        assertThatThrownBy(() -> price.setInput()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(() -> price.setInput("-1000")).isInstanceOf(NumberFormatException.class);
    }
}