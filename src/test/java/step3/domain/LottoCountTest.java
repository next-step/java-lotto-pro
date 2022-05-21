package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

    @DisplayName("LottoCount를 생성한다.")
    @Test
    void create() {
        assertThat(new LottoCount(1)).isEqualTo(new LottoCount(1));
    }

    @DisplayName("LottoCount는 0 이상이어야 한다.")
    @Test
    void invalid_create() {
        assertThatThrownBy(() -> {
            new LottoCount(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoCount를 반환한다.")
    @Test
    void get() {
        LottoCount manualLottoCount = new LottoCount(5);
        assertThat(manualLottoCount.get()).isEqualTo(5);
    }
}