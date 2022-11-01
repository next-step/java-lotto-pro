package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.LottoGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoManualCountTest {

    private LottoGame lottoGame = new LottoGame();

    @Test
    @DisplayName("수동으로 구매할 로또 개수는 숫자 타입이여야 한다." +
            "또한 구입금액으로 가능한 최대 구매 가능 갯수보다 같거나 작아야 한다.")
    void validation_manual_count() {
        assertThat(lottoGame.convertAndValidationManualCount(5000, "5")).isEqualTo(5);
        assertThatThrownBy(() -> lottoGame.convertAndValidationManualCount(5000, "5개"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoGame.convertAndValidationManualCount(5000, "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
