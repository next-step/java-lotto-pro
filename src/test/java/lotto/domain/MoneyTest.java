package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("돈 테스트")
class MoneyTest {

    @DisplayName("수동 입력 돈 초과 테스트")
    @Test
    void isExceedMoney() {
        Money totalMoney = Money.of(8000);
        Money manualMoney = Money.of(10000);
        assertTrue(manualMoney.isExceedMoney(totalMoney));
    }

}