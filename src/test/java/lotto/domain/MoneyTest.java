package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.constant.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"4000:4", "5550:5", "150001:150"}, delimiter = ':')
    void 입력된_돈으로_살_수_있는_로또_개수_반환(int inputMoney, int expectLottoCount) {
        Money money = Money.createLottoMoney(inputMoney);
        assertThat(money.maxLottoCount()).isEqualTo(expectLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, 500, 999})
    void 입력된_돈이_1000보다_작을_경우_에러_발생(int inputMoney) {
        assertThatThrownBy(() -> Money.createLottoMoney(inputMoney)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.로또를_구매하기_위해서는_1000원_이상_필요.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"5000:3000:1.66", "5000:8500:0.62", "50000:154320:0.32", "30000:193430:0.15"}, delimiter = ':')
    void 당첨금과_로또_구매_비용_간_비율은_소숫점_셋째자리_버림_반환(int totalPrize, int inputMoney, double profit) {
        Lottos lottos = new Lottos(Money.createLottoMoney(inputMoney));
        Money totalPrice = lottos.findTotalPrice();
        assertThat(totalPrice.findProfitsRatio(Money.createMoney(totalPrize))).isEqualTo(profit);
    }

    @Test
    void 인자로_넘긴_돈보다_주어진_돈이_작을_경우_true_반환() {
        Money money = Money.createMoney(5000);
        assertThat(money.isLessThan(Money.createMoney(6000))).isTrue();
    }
}
