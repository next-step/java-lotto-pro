import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void newLottoNumber() {
        assertThatThrownBy(() -> new LottoNumber("1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void newLottoNumberWithString() {
        assertThatThrownBy(() -> new LottoNumber("a"))
                .isInstanceOf(NumberFormatException.class);
    }

}
