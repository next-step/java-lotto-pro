package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoMoneyCheckerTest {

    LottoMoneyChecker lottoMoneyChecker = new LottoMoneyChecker();

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