package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.generator.DefaultNumberGeneratorStrategy;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator =
            LottoGenerator.from(LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy()));

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "17500:17", "1000:1"}, delimiter = ':')
    @DisplayName("로또 구입 금액이 입력되면 구입할 수 있는 로또 갯수만큼 로또를 생성한다.(로또 한 장당 가격은 1000원)")
    void generateLotto1(double input, int expected) {
        List<Lotto> lottos = lottoGenerator.generate(Money.from(input));
        Assertions.assertThat(lottos).hasSize(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:4", "10:12"}, delimiter = ':')
    @DisplayName("수동 로또 목록과 같이 자동으로 로또를 생성한 후 전체 로또 수를 확인한다.")
    void generateLotto3(int input, int expected) {
        List<Lotto> manualLottos = new ArrayList<>();
        manualLottos.add(Lotto.fromBy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        manualLottos.add(Lotto.fromBy(Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<Lotto> lottos = lottoGenerator.generate(input, manualLottos);
        Assertions.assertThat(lottos).hasSize(expected);
    }
}
