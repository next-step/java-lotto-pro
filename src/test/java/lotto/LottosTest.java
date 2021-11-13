package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.service.ManualLottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    Lottos lottos;
    List<String> inputManualLottoNumbersString;

    @BeforeEach
    void init() {
        lottos = new Lottos(2, 1);
        inputManualLottoNumbersString = Arrays.asList("1,2,3,4,5,6");
    }

    @Test
    void 수동로또_개수_유효검사() {
        int totalLottoCount = 3;
        int manualLottoCount = 5;
        assertThatThrownBy(() ->
                new Lottos(totalLottoCount, manualLottoCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동로또_개수_0미만_오류() {
        int totalLottoCount = 3;
        int manualLottoCount = -1;
        assertThatThrownBy(() ->
                new Lottos(totalLottoCount, manualLottoCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동로또_생성() {
        lottos.createManualLottos(inputManualLottoNumbersString);
        assertThat(lottos.getManualLotts()).contains(new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"))));
    }
}
