package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoMoneyCheckerTest {

    LottoMoneyChecker lottoMoneyChecker = new LottoMoneyChecker();

    @DisplayName("calculatePurchasingAutoGameCount 예상한 갯수만큼 구매 가능한지 테스트(수동 구매가 없을 때)")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "0,1,0",
            "0,500,0",
            "0,1000,1",
            "0,1500,1",
            "0,2000,2"})
    void calculatePurchasingCountTest01(int countOfManualCount, int money, int expectedCount) {
        int result = lottoMoneyChecker.calculatePurchasingAutoGameCount(countOfManualCount, money);
        assertThat(result)
                .isEqualTo(expectedCount);
    }

    @DisplayName("calculatePurchasingAutoGameCount 예상한 갯수만큼 구매 가능한지 테스트(수동 구매가 존재할 경우)")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "1,1000,0",
            "1,2000,1",
            "2,2000,0",
            "2,3000,1"})
    void calculatePurchasingCountTest02(int countOfManualCount, int money, int expectedCount) {
        int result = lottoMoneyChecker.calculatePurchasingAutoGameCount(countOfManualCount, money);
        assertThat(result)
                .isEqualTo(expectedCount);
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