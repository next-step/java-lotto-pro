package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.LottoMoney;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1,0,1,2,3,999})
    @DisplayName("금액이 천원 미만이면 예외발생")
    void test_that_it_throw_exception_if_money_less_then_1000(int money) {
        //given,when,then
        assertThatThrownBy(() -> new LottoMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 최소 1000원이상 입력해야합니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {1001,9999,9990,7700})
    @DisplayName("금액이 천원 미만이면 예외발생")
    void test_that_it_throw_exception_if_money_not_1000_unit(int money) {
        //given,when,then
        assertThatThrownBy(() -> new LottoMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1000원 단위로 입력해야합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "6000:6", "5000:5", "12000:12"}, delimiter = ':')
    @DisplayName("개수를 입력하면 로또가격의 총합을 반환")
    void test_that_it_throw_exception_if_money_not_1000_unit(int money,int count) {
        //given,when
        LottoMoney lottoMoney = new LottoMoney(1000);

        //then
        assertThat(lottoMoney.getSumOfPriceLottos(count)).isEqualTo(money);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "6000:6", "5000:5", "12000:12"}, delimiter = ':')
    @DisplayName("구입가격을 입력하면 구입가격대비 구매개수를 반환")
    void test_that_returns_number_of_purchases_compared_purchase(int money, int count) {
        //given,when
        LottoMoney lottoMoney = new LottoMoney(money);

        //then
        assertThat(lottoMoney.getCountOfPurchasePrice()).isEqualTo(count);
    }




}
