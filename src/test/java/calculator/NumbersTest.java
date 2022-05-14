package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {

    @Test
    public void 잘못된_기본_구분자를_가진_문자() {
        assertThatThrownBy(() -> new Numbers("1|2"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 잘못된_커스텀_구분자를_가진_문자() {
        assertThatThrownBy(() -> new Numbers("//;\n1;2;3|true"))
                .isInstanceOf(RuntimeException.class);
    }

}
