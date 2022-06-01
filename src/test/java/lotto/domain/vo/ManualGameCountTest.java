package lotto.domain.vo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ManualGameCountTest {

    @DisplayName("ManualGameCount 생성에 실패")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "2,1000",
            "-1,1000",
            "3,2000"})
    void ManualGameCount생성자_실패(int count, int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new ManualGameCount(count, money);
        });
    }

    @DisplayName("ManualGameCount 생성에 성공")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "0,2000",
            "1,2000",
            "2,2000"})
    void ManualGameCount생성자_성공(int count, int money) {
        Assertions.assertDoesNotThrow(() -> {
            ManualGameCount manualGameCount = new ManualGameCount(count, money);
            assertThat(manualGameCount.getCount()).isEqualTo(count);
        });
    }
}