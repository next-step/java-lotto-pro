package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualCountTest {

    @Test
    @DisplayName("ManualCount 생성 테스트")
    void create_manual_count_test() {
        ManualCount manualCount = ManualCount.of(10, 5);
        assertThat(manualCount).isInstanceOf(ManualCount.class);

    }

    @Test
    @DisplayName("ManualCount 음수 오류 테스트")
    void exception_minus_test() {
        assertThatThrownBy(() -> ManualCount.of(10, -5))
                .isInstanceOf(LottoException.class);
    }

    @Test
    @DisplayName("ManualCount 구입 개수 테스트")
    void exception_buy_count_test() {
        assertThatThrownBy(() -> ManualCount.of(10, 15))
                .isInstanceOf(LottoException.class);
    }

}