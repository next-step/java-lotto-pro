package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.ManualLottos;
import lotto.domain.ManualLottosCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottosTest {
    ManualLottos manualLottos;
    List<String> inputManualLottoNumbersString;

    @BeforeEach
    void init() {
        manualLottos = new ManualLottos(new ManualLottosCount(2,1));
        inputManualLottoNumbersString = Arrays.asList("1,2,3,4,5,6");
        manualLottos.createManualLottos(inputManualLottoNumbersString);
    }

    @Test
    void 수동로또_개수_유효검사() {
        int totalLottoCount = 3;
        int manualLottoCount = 5;
        assertThatThrownBy(() ->
                new ManualLottosCount(totalLottoCount, manualLottoCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동로또_개수_0미만_오류() {
        int totalLottoCount = 3;
        int manualLottoCount = -1;
        assertThatThrownBy(() ->
                new ManualLottosCount(totalLottoCount, manualLottoCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동로또_생성() {
        manualLottos.createManualLottos(inputManualLottoNumbersString);
        assertThat(manualLottos.getManualLottos()).contains(new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"))));
    }
}
