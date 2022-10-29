package lotto.model.money.to.buy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyToBuyTest {

    static class MoneyToBuyForTest extends MoneyToBuy {
        public MoneyToBuyForTest(String input) {
            super(input);
        }

        public boolean isMoneySameWith(int money) {
            return this.money == money;
        }
    }

    @Nested
    @DisplayName("MoneyToBuy 생성자 테스트")
    class Constructor {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 1000, 14000, Integer.MAX_VALUE})
        @DisplayName("구입 금액이 0 이상의 양수이면 MoneyToBuy 객체 생성 성공")
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
    }

    @Nested
    @DisplayName("MoneyToBuy 클래스 money 값 확인")
    class MoneyAfterDiscardingRemainder {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 999})
        @DisplayName("사용자가 입력한 구입 금액이 1000 보다 작으면 money 값은 0 이 된다")
        void moneyZero(int value) {
            final String input = String.valueOf(value);
            final MoneyToBuyForTest moneyToBuyForTest = new MoneyToBuyForTest(input);
            assertThat(moneyToBuyForTest.isMoneySameWith(0)).isTrue();
        }

        @ParameterizedTest
        @CsvSource(value = {"1000,1000", "2500,2000", "987654321,987654000"}, delimiter = ',')
        @DisplayName("사용자 입력한 구입 금액에서 나머지를 제거한 값이 money 가 된다")
        void moneySame(String input, int money) {
            final MoneyToBuyForTest moneyToBuyForTest = new MoneyToBuyForTest(input);
            assertThat(moneyToBuyForTest.isMoneySameWith(money)).isTrue();
        }
    }
}
