package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:false", "999:true", "a:true", "19991:false"}, delimiter = ':')
    public void createMoneyTest(String money, boolean isException) {
        if (isException) {
            assertThatThrownBy(() -> new Money(money)).isInstanceOf(IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> new Money(money));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "12000:12", "1414:1", "5123:5"}, delimiter = ':')
    public void purchaseTicketTest(String money, int expected) {
        Money moneyEntity = new Money(money);
        assertThat(moneyEntity.purchaseTicket()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1000:이득", "2000:500:손해", "1000:2000:이득"}, delimiter = ':')
    public void isBenefitTest(String money, long reward, String isBenefit) {
        Money moneyEntity = new Money(money);
        assertThat(moneyEntity.isBenefit(reward)).isEqualTo(isBenefit);
    }

    @ParameterizedTest
    @CsvSource(value = {"1500:0.75", "2500:1.25", "3000:1.5", "4500:2.25"}, delimiter = ':')
    public void getProfitTest(long reward, double expected) {
        Money money = new Money("2000");
        assertThat(money.getProfitRate(reward)).isEqualTo(expected);
    }
}
