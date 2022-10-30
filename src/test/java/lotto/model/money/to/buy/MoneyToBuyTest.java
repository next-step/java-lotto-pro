package lotto.model.money.to.buy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyToBuyTest {
    @Nested
    @DisplayName("MoneyToBuy 생성자 테스트")
    class Constructor {
        @ParameterizedTest
        @ValueSource(ints = {0, 1000, 14000, 999999000})
        @DisplayName("구입 금액이 거스름돈 없이 로또를 0 장 이상 구매 가능한 금액이면 MoneyToBuy 객체 생성 성공")
        void success(int value) {
            final String input = String.valueOf(value);
            assertDoesNotThrow(() -> new MoneyToBuy(input));
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MIN_VALUE, -96000, -1000, -2, -1})
        @DisplayName("구입 금액이 음수이면 MoneyToBuy 객체 생성 실패")
        void errorInputNegative(int value) {
            final String input = String.valueOf(value);
            assertThrows(NumberFormatException.class, () -> new MoneyToBuy(input));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("구입 금액이 null 또는 \"\"(empty string) 이면 MoneyToBuy 객체 생성 실패")
        void errorInputNegative(String input) {
            assertThrows(NumberFormatException.class, () -> new MoneyToBuy(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "b", "1aa", "!", ".", "one", "non digit", ""})
        @DisplayName("구입 금액 입력값이 숫자가 아니면 MoneyToBuy 객체 생성 실패")
        void errorInputNotDigit(String input) {
            assertThrows(NumberFormatException.class, () -> new MoneyToBuy(input));
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 999, 15900, 20000100})
        @DisplayName("구입 금액이 로또 한 장 가격, 즉 1000 원으로 나누어 떨어지지 않으면 MoneyToBuy 객체 생성 실패")
        void moneyZero(int value) {
            final String input = String.valueOf(value);
            assertThrows(NumberFormatException.class, () -> new MoneyToBuy(input));
        }
    }
}
