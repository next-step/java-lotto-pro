package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Input;
import lotto.util.Constants;

public class InputTest {
    @Test
    @DisplayName("구입금액_검증_숫자")
    public void input_validate_number() {
        assertThatThrownBy(() -> new Input("abcd")).hasMessage(Constants.ERR_VALUE_NOT_VALID);
    }
    
    @Test
    @DisplayName("구입금액_검증_null")
    public void input_validate_null() {
        assertThatThrownBy(() -> new Input(null)).hasMessage(Constants.ERR_NULL_VALUE);
    }
    
    @Test
    @DisplayName("구입금액_검증_빈값")
    public void input_validate_emtpy() {
        assertThatThrownBy(() -> new Input("")).hasMessage(Constants.ERR_NULL_VALUE);
    }
}
