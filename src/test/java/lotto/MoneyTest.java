package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Money;
import lotto.util.Constants;

public class MoneyTest {
    @Test
    @DisplayName("구입금액이_숫자가_아닌_경우_오류_발생")
    public void money_validate_number() {
        assertThatThrownBy(() -> new Money("abcd")).hasMessage(Constants.ERR_VALUE_NOT_VALID);
    }
    
    @Test
    @DisplayName("구입금액이_null인_경우_오류_발생")
    public void money_validate_null() {
        assertThatThrownBy(() -> new Money(null)).hasMessage(Constants.ERR_NULL_VALUE);
    }
    
    @Test
    @DisplayName("구입금액이_빈값인_경우_오류_발생")
    public void money_validate_emtpy() {
        assertThatThrownBy(() -> new Money("")).hasMessage(Constants.ERR_NULL_VALUE);
    }
    
    @Test
    @DisplayName("구입금액이_1000미만인_경우_오류_발생")
    public void money_validate_under_thousand() {
        assertThatThrownBy(() -> new Money("999")).hasMessage("1000 이상의 숫자를 입력해 주세요.");
    }    
}
