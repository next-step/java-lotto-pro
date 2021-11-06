package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoughtLottoTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1000,1,0", "50000,30,20"
    })
    @DisplayName("구입한 로또의 수동/자동 개수 확인")
    public void buyToLottoTest(String money, String manualCount, int autoCount) {
        BoughtLotto boughtLotto = BoughtLotto.of(money, manualCount);

        assertThat(boughtLotto.getManualCount()).isEqualTo(Integer.parseInt(manualCount));
        assertThat(boughtLotto.getAutoCount()).isEqualTo(autoCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0", "999", "1001", "-1", "a"
    })
    @DisplayName("1000원단위로 입력할 수 있으며 1000보다 작은수는 입력할 수 없다.")
    public void buyToLottoTest_fail(String money) {
        assertThatThrownBy(() -> BoughtLotto.of(money, "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2", "a", "-1", " "
    })
    @DisplayName("수동 로또번호 수는 구입 가능한 범위이거나 0보다 커야합니다.")
    public void buyLottoManualCount_fail(String manualCount) {
        assertThatThrownBy(() -> BoughtLotto.of("1000", manualCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}