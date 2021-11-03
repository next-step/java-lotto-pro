package lotto.domain.purchase;

import lotto.domain.purchase.PurchaseMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseMoneyTest {

    @ParameterizedTest(name = "구입 금액 객체 생성: [{index}] {0}")
    @ValueSource(ints = {10000, 500000})
    @DisplayName("구입 금액은 1000원 단위의 정수 값이다.")
    void createPurchaseMoney(int money) {
        //given //when
        PurchaseMoney purchaseMoney = new PurchaseMoney(money);

        //then
        assertThat(purchaseMoney).isEqualTo(new PurchaseMoney(money));
    }

    @Test
    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    void validateNegative() {
        //given
        int money = -1000;

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseMoney(money));
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    void validateDivisible() {
        //given
        int money = 1500;

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchaseMoney(money));
    }
}
