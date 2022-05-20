package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualLottoCountTest {

    @DisplayName("수동로또 구매 개수는 0 이상이어야 한다.")
    @Test
    void create() {
        assertThat(new ManualLottoCount(1)).isEqualTo(new ManualLottoCount(1));
    }

    @DisplayName("수동로또 구매 개수는 0 이상이어야 한다.")
    @Test
    void invalid_create() {
        assertThatThrownBy(() -> {
            new ManualLottoCount(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동로또 구매 개수를 반환한다.")
    @Test
    void get() {
        ManualLottoCount manualLottoCount = new ManualLottoCount(5);
        assertThat(manualLottoCount.get()).isEqualTo(5);
    }
}