package model;

import exception.BuyableLottoNumberSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountTest {

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("정상적으로 생성되는 테스트")
    void lotto_purchase_amount_contsructor_success_test() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("1000");

        assertThat(lottoPurchaseAmount).isEqualTo(new LottoPurchaseAmount("1000"));
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @DisplayName("1000단위가 아닐 경우 예외를 발생시키는 테스트")
    @ValueSource(strings = { "1001", "1500", "1600" })
    void amount_valid_check_test(String amount) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @DisplayName("양수가 아닐 경우 예외를 발생시키는 테스트")
    @ValueSource(strings = { "-100", "ㅇㄴㅁㅇㅁㄴ", "aba@" })
    void isNumber_test(String amount) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("로또 금액에 맞춘 구매량을 구하는 테스트")
    void get_quantity_per_amount_lotto_test() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("14000");

        assertThat(lottoPurchaseAmount.getQuantityPerAmountLotto()).isEqualTo(14);
    }

    @Test
    @DisplayName("구매 수량 확인 테스트 ( 구매 가능 )")
    void valid_check_buyable_lotto_success_test() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("14000");

        lottoPurchaseAmount.validCheckBuyableLotto("14");
        assertThat(lottoPurchaseAmount.getQuantityPerAmountLotto()).isEqualTo(14);
    }

    @Test
    @DisplayName("구매 수량 확인 테스트 ( 구매 실패 )")
    void valid_check_buyable_lotto_fail_test() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("14000");

        assertThatThrownBy(() -> lottoPurchaseAmount.validCheckBuyableLotto("15"))
                .isInstanceOf(BuyableLottoNumberSizeException.class);
    }
}