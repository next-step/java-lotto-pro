package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("Money 정상생성")
    public void Money_정상생성() {
        Money money = new Money(1000);
        assertThat(money.getPrice()).isEqualTo(1000);
    }

    @Test
    @DisplayName("Money 음수 입력하면 예외가 발생해야 한다.")
    public void Money_음수() {
        assertThatThrownBy(() -> {
            Money money = new Money(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Money lotto 한장 미만 금액 입력하면 예외가 발생해야 한다.")
    public void Money_lotto_최소금액미만() {
        assertThatThrownBy(() -> {
            Money money = new Money(500);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="Money 금액으로 구매 가능한 lotto 개수 반환: {0}원 - {1}개")
    @CsvSource(value = {"5000:5", "1001:1", "1999:1"}, delimiter = ':')
    void Money_구매가능_lotto_개수(int amount, int count){
        Money money = new Money(amount);
        assertThat(money.lottoTotalCount()).isEqualTo(count);
    }

    @Test
    @DisplayName("수동 Lotto 개수 음수 입력하면 예외가 발생해야 한다.")
    public void Money_수동_Lotto_Count_음수() {
        assertThatThrownBy(() -> {
            Money money = new Money(1000);
            money.checkManualLottoCount(-100);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 Lotto 개수 price로 구입 가능한 Lotto 개수를 초과하여 입력하면 예외가 발생해야 한다.")
    public void Money_수동_Lotto_Count_초과_total_Lotto_Count() {
        assertThatThrownBy(() -> {
            Money money = new Money(1000);
            money.checkManualLottoCount(100);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
