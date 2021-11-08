package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TryCountTest {

    @DisplayName("전체 회수와 수동 회수로 자동 회수를 계산한다")
    @Test
    void createTryCount() {
        TryCount tryCount = new TryCount(100, 33);
        assertAll(
                () -> assertThat(tryCount.getAutoTryCount()).isEqualTo(67),
                () -> assertThat(tryCount.getManualTryCount()).isEqualTo(33)
        );
    }

}
