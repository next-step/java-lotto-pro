package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoMoneyCheckerTest {

    LottoMoneyChecker lottoMoneyChecker = new LottoMoneyChecker();

    @DisplayName("calculatePurchasingCount 예상한 갯수만큼 구매 가능한지 테스트")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "1,0",
            "500,0",
            "1000,1",
            "1500,1",
            "2000,2"})
    void calculatePurchasingCountTest01(int money, int expectedCount) {
        int result = lottoMoneyChecker.calculatePurchasingCount(money);
        assertThat(result)
                .isEqualTo(expectedCount);
    }

    @DisplayName("음수의 값을 입력했을 때 구매할 수 없다는 exception이 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -1})
    void calculatePurchasingCountTest02(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = lottoMoneyChecker.calculatePurchasingCount(money);
        });
    }

    @DisplayName("수동 구매가 가능한 경우를 테스트")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "0, 3000",
            "1, 3000",
            "2,3000",
            "3,3000"})
    void validateCountOfManualGameTest01(int countOfManualGame, int money) {
        assertDoesNotThrow(() -> {
            lottoMoneyChecker.validateCountOfManualGame(countOfManualGame, money);
        });
    }

    @DisplayName("수동 구매가 불가능한 경우를 테스트")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "-1, 3000",
            "4, 3000"})
    void validateCountOfManualGameTest02(int countOfManualGame, int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoMoneyChecker.validateCountOfManualGame(countOfManualGame, money);
        });
    }
}