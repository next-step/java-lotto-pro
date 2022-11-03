package lotto.domain.money;

import lotto.status.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @ParameterizedTest
    @DisplayName("Money 클래스 생성")
    @ValueSource(ints = {14000, 1600})
    void create_money(int amount) {
        Money money = new Money(amount);
        assertThat(new Money(amount)).isEqualTo(money);
    }

    @ParameterizedTest
    @DisplayName("입력 받은 액수가 음수인 경우 IllegalArgumentException 발생")
    @ValueSource(ints = {-1, -2, -3})
    void create_money_throw_exception(int amount) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(amount)).withMessage(ErrorStatus.INVALID_MONEY_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("가지고 있는 돈으로 로또 구매가능 개수 반환")
    @MethodSource("amountAndLottoPrice")
    void money_possible_buy_lotto(int amount, int price, int expect) {
        Money money = new Money(amount);
        assertThat(money.possibleBuyLottoCount(price)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("가지고 있는 돈으로 로또 구매 할 수 없을 시 RuntimeException")
    @MethodSource("amountAndLottoPriceError")
    void money_buy_lotto_exception(int amount, int price) {
        Money money = new Money(amount);
        assertThatThrownBy(() -> money.possibleBuyLottoCount(price)).isInstanceOf(RuntimeException.class).hasMessage(ErrorStatus.CAN_NOT_PURCHASE_LOTTO.getMessage());
    }

    @ParameterizedTest
    @DisplayName("금액이 로또 가격으로 딱 나누어 떨어지지 않았을때 로또 개수 반환")
    @MethodSource("returnLottPiece")
    void return_use_money(int amount, int price, int expect) {
        Money money = new Money(amount);
        int lottoCount = money.possibleBuyLottoCount(price);
        assertThat(lottoCount).isEqualTo(expect);
    }

    private static Stream<Arguments> amountAndLottoPrice() {
        return Stream.of(
                Arguments.of(1000, 300, 3),
                Arguments.of(1000, 200, 5)
        );
    }

    private static Stream<Arguments> amountAndLottoPriceError() {
        return Stream.of(
                Arguments.of(1000, 3000),
                Arguments.of(1000, 4000)
        );
    }

    private static Stream<Arguments> investmentTestCase() {
        return Stream.of(
                Arguments.of(1000, 300, 900),
                Arguments.of(1000, 400, 800)
        );
    }

    private static Stream<Arguments> returnLottPiece() {
        return Stream.of(
                Arguments.of(1000, 300, 3),
                Arguments.of(1000, 400, 2)
        );
    }
}
