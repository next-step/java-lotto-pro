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
        Money money = new Money(10000);
        assertThat(money.getAmount()).isEqualTo(10000);
    }

    @ParameterizedTest(name="금액으로 구매 가능한 로또 개수 반환: {0}원 - {1}개")
    @CsvSource(value = {"0:0", "999:0", "1000:1", "1001:1", "1999:1"}, delimiter = ':')
    void Money_구매가능_로또_개수(int amount, int count){
        Money money = new Money(amount);
        assertThat(money.lottoCountToBuy()).isEqualTo(count);
    }
}
