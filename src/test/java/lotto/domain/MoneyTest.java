package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @Test
    @DisplayName("Money 정상 생성")
    void Money_정상_생성(){
        Money money = new Money(1000);
        assertThat(money.getAmount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("Money 비정상 생성: 음수값")
    void Money_비정상_생성_음수값(){
        assertThatThrownBy(() -> {
            Money money = new Money(-10000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Money 비정상 생성: 1000원 미만")
    void Money_비정상_생성_1000원_미만(){
        assertThatThrownBy(() -> {
            Money money = new Money(100);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="금액으로 구매 가능한 로또 개수 반환: {0}원 - {1}개")
    @CsvSource(value = {"1000:1", "1001:1", "1999:1"}, delimiter = ':')
    void Money_구매가능_로또_개수(int amount, int count){
        Money money = new Money(amount);
        assertThat(money.lottoCountToBuy()).isEqualTo(count);
    }

    @ParameterizedTest(name="수익률 계산")
    @CsvSource(value = {"100000:5000:0.05", "100500:5000:0.05"}, delimiter = ':')
    void Money_수익률_계산(int initialMoney, int winningPrice, double profit){
        Money money = new Money(initialMoney);
        assertThat(money.calculateProfit(winningPrice)).isEqualTo(profit);
    }
}
