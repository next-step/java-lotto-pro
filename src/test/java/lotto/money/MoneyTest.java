package lotto.money;

import lotto.Purchasable;
import lotto.money.CanNotPurchaseException;
import lotto.money.Money;
import lotto.money.MoneyFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Money 클래스 테스트")
class MoneyTest {

    private static final Purchasable PRICE_IS_ONE_THOUSAND = () -> Money.ONE_THOUSAND;
    private static final Purchasable PRICE_IS_TEN = () -> Money.of("10");
    private static final Purchasable PRICE_IS_ONE = () -> Money.of("1");

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

    @DisplayName("Money로 Purchasable 구매가능 여부 반환")
    @ParameterizedTest
    @ArgumentsSource(CanPurchaseArgumentsProvider.class)
    void canPurchase(Purchasable purchasable, boolean expected) {
        Money ten = Money.of("10");
        assertThat(ten.canPurchase(purchasable)).isEqualTo(expected);
    }

    static class CanPurchaseArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(PRICE_IS_ONE_THOUSAND, false),
                    Arguments.of(PRICE_IS_TEN, true),
                    Arguments.of(PRICE_IS_ONE, true),
                    Arguments.of(null, false)
            );
        }
    }

    @DisplayName("Money로 Purchasable을 구매 성공")
    @ParameterizedTest
    @ArgumentsSource(SuccessfulPurchaseArgumentsProvider.class)
    void successfulPurchase(Purchasable purchasable, Money expected) {
        assertThat(Money.ONE_THOUSAND.purchase(purchasable)).isEqualTo(expected);
    }

    static class SuccessfulPurchaseArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(PRICE_IS_ONE_THOUSAND, Money.of(0)),
                    Arguments.of(PRICE_IS_TEN, Money.of(990)),
                    Arguments.of(PRICE_IS_ONE, Money.of(999))
            );
        }
    }

    @DisplayName("Money로 Purchasable을 구매 실패")
    @ParameterizedTest
    @NullSource
    @ArgumentsSource(FailurePurchaseArgumentsProvider.class)
    void failurePurchase(Purchasable purchasable) {
        assertThatThrownBy(() -> {
            Money.of("1").purchase(purchasable);
        })
        .isInstanceOf(CanNotPurchaseException.class)
        .hasMessageContaining("구매가 불가능 합니다.");
    }

    static class FailurePurchaseArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(PRICE_IS_ONE_THOUSAND),
                    Arguments.of(PRICE_IS_TEN)
            );
        }
    }
}
