package lotto;

import lotto.domain.ManualLotto;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ManualLottoTest {
    @Test
    @DisplayName("ManualLotto 생성한다")
    void ManualLotto_생성() {
        Money money = Money.of(3000, 1);
        List<String> inputLottoNumbers = Arrays.asList("1,2,3,4,5,6");
        ManualLotto manualLotto = ManualLotto.of(money, inputLottoNumbers);

        assertThat(manualLotto.getInputLottoNumbers().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동 로또 개수 계산")
    void getAutoCount() {
        Money money = Money.of(3000, 1);
        List<String> inputLottoNumbers = Arrays.asList("1,2,3,4,5,6");
        ManualLotto manualLotto = ManualLotto.of(money, inputLottoNumbers);

        assertThat(manualLotto.getAutoCount()).isEqualTo(2);
    }
}
