package lotto.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Money 클래스 테스트")
class MoneyTest {

    @DisplayName("Money 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1","10", "100", "1000"})
    void successfulCreate(String value) {
        assertThat(Money.of(value)).isNotNull();
    }

    @DisplayName("Money 생성 실패")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1"})
    void failureCreate(String value) {
        assertThatThrownBy(() -> {
            Money.of(value);
        })
        .isInstanceOf(MoneyFormatException.class)
        .hasMessageContaining("Money 형식에 어긋납니다.");
    }

    @DisplayName("Money로 다른 Money 차감 여부 반환")
    @ParameterizedTest
    @ArgumentsSource(CanDeductArgumentsProvider.class)
    void canDeduct(Money money, boolean expected) {
        final Money ten = Money.of(10);
        assertThat(ten.canDeduct(money)).isEqualTo(expected);
    }

    static class CanDeductArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Money.ONE_THOUSAND, false),
                    Arguments.of(Money.of(10), true),
                    Arguments.of(Money.of(1), true),
                    Arguments.of(null, false)
            );
        }
    }

    @DisplayName("Money로 다른 Money를 차감")
    @ParameterizedTest
    @ArgumentsSource(SuccessfulDeductArgumentsProvider.class)
    void successfulPurchase(Money money, Money expected) {
        assertThat(Money.ONE_THOUSAND.deduct(money)).isEqualTo(expected);
    }

    static class SuccessfulDeductArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Money.ONE_THOUSAND, Money.of(0)),
                    Arguments.of(Money.of(10), Money.of(990)),
                    Arguments.of(Money.of(1), Money.of(999))
            );
        }
    }

    @DisplayName("Money로 다른 Money를 차감 실패")
    @ParameterizedTest
    @NullSource
    @ArgumentsSource(FailureDeductArgumentsProvider.class)
    void failureDeduct(Money money) {
        assertThatThrownBy(() -> {
            Money.of("1").deduct(money);
        })
        .isInstanceOf(CanNotDeductException.class)
        .hasMessageContaining("차감이 불가능 합니다.");
    }

    static class FailureDeductArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Money.ONE_THOUSAND),
                    Arguments.of(Money.of(10))
            );
        }
    }

    @DisplayName("Money와 또 다른 Money를 더한다")
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "1,0,1",
            "0,1,1"
    })
    void add(long moneyValue, long otherMoneyValue, long expectedValue) {
        final Money money = Money.of(moneyValue);
        final Money otherMoney = Money.of(otherMoneyValue);
        assertThat(money.add(otherMoney)).isEqualTo(Money.of(expectedValue));
    }

    @DisplayName("Money와 특정 수 만큼 곱한다")
    @ParameterizedTest
    @CsvSource({
            "1,1,1",
            "1,2,2",
            "2,2,4",
            "0,1,0",
    })
    void multiple(long moneyValue, long multiple, long expectedValue) {
        final Money money = Money.of(moneyValue);
        assertThat(money.multiple(multiple)).isEqualTo(Money.of(expectedValue));
    }

    @DisplayName("Money와 또 다른 Money의 퍼센티지를 반환")
    @ParameterizedTest
    @CsvSource({
            "0, 0, 0.00",
            "1, 0, 0.00",
            "0, 1, 0.00",
            "1, 1, 1.00",
            "1, 2, 0.50",
            "2, 1, 2.00",
    })
    void percentage(long moneyValue, long otherMoneyValue, BigDecimal expected) {
        final Money money = Money.of(moneyValue);
        final Money otherMoney = Money.of(otherMoneyValue);
        assertThat(money.percentage(otherMoney)).isEqualByComparingTo(expected);
    }
}
