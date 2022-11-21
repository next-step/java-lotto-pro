package study.step4.helper;

import org.junit.jupiter.api.Test;
import study.step4.models.Lottos;
import study.step4.models.Money;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakerTest {
    @Test
    void 구입_금액대로_자동_로또를_발급() {
        Money inputMoney = new Money("14000");
        List<String> manualLottosString = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7");

        Lottos autoLottos = LottoMaker.makeLottos(inputMoney.numberAvailable(), manualLottosString);

        assertThat(autoLottos.size()).isEqualTo(inputMoney.numberAvailable());
    }
}
