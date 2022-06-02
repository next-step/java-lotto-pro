package lotto.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AutoGameCountTest {

    @DisplayName("AutoGameCount 생성한 이후 count 숫자가 정확한지 테스트")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "0,2000,2",
            "1,2000,1",
            "2,2000,0"})
    void AutoGameCountTest01(int manualCount, int money, int expectedCount) {
        ManualGameCount manualGameCount = new ManualGameCount(manualCount, money);
        AutoGameCount autoGameCount = new AutoGameCount(manualGameCount, money);
        assertThat(autoGameCount.getCount()).isEqualTo(expectedCount);
    }
}