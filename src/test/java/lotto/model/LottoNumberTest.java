package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void instantiate_성공() {
        LottoNumber number = new LottoNumber(3);
        assertThat(number).isNotNull();
        assertThat(number).isInstanceOf(LottoNumber.class);
    }

    @Test
    void instantiate_실패() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void isValueObject() {
        LottoNumber number = new LottoNumber(1);
        assertThat(number).isEqualTo(new LottoNumber(1));
        assertThat(number).isNotEqualTo(new LottoNumber(45));
    }

    @Test
    void toStringTest() {
        LottoNumber number = new LottoNumber(3);
        assertThat(number.toString()).isEqualTo("3");
    }
}
