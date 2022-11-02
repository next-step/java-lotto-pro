package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Money;

public class MoneyTest {
    @Test
    @DisplayName("구입금액이 숫자가 아닌 경우 오류 발생")
    public void money_validate_number() {
        assertThatThrownBy(() -> new Money("abcd")).hasMessage("올바른 숫자를 입력해 주세요.");
    }
    
    @Test
    @DisplayName("구입금액이 null인 경우 오류 발생")
    public void money_validate_null() {
        assertThatThrownBy(() -> new Money(null)).hasMessage("값을 입력해 주세요");
    }
    
    @Test
    @DisplayName("구입금액이 빈값인 경우 오류 발생")
    public void money_validate_emtpy() {
        assertThatThrownBy(() -> new Money("")).hasMessage("값을 입력해 주세요");
    }
    
    @Test
    @DisplayName("구입금액이 1000미만인 경우 오류 발생")
    public void money_validate_under_thousand() {
        assertThatThrownBy(() -> new Money("999")).hasMessage("1000 이상의 숫자를 입력해 주세요.");
    }    
}
