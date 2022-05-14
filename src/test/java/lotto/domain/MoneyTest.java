package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @Test
    @DisplayName("Money 정상 생성")
    void Money_정상_생성(){
        Money money = new Money("10000");
        assertThat(money.getAmount()).isEqualTo(10000);
    }

    @ParameterizedTest(name="Money 비정상 생성: {0}")
    @ValueSource(strings = {"-10000","abcd"})
    void Money_비정상_생성(String amount){
        assertThatThrownBy(() -> {
            Money money = new Money(amount);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
