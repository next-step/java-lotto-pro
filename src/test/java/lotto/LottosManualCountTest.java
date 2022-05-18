package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottosManualCount;
import lotto.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottosManualCount 클래스")
public class LottosManualCountTest {

    private Price price;

    @BeforeEach
    void setUp() {
        price = new Price(5000);
    }

    @DisplayName("입력한 수동 로또 번호 개수가 음수면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, -2, -8})
    void manualLottoCountIsMinusThenIllegalArgumentException(final int manualLottoCount) {
        assertThatThrownBy(() -> new LottosManualCount(price, manualLottoCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 수동 로또 번호 개수가 총 로또 개수를 초과하면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8})
    void manualLottoCountExceedsTotalLottoCountThenIllegalArgumentException(final int manualLottoCount) {
        assertThatThrownBy(() -> new LottosManualCount(price, manualLottoCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
