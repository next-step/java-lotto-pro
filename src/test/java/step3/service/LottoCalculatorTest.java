package step3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.Lotto;
import step3.model.LottoResults;
import step3.model.Lottos;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCalculatorTest {

    private LottoCalculator lottoCalculator;
    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,10)));
        lottos.add(new Lotto(Arrays.asList(5,10,13,21,30,34)));
        lottos.add(new Lotto(Arrays.asList(21,25,27,29,30,33)));
        lottos.add(new Lotto(Arrays.asList(20,30,32,40,42,43)));

        this.lottoCalculator = new LottoCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,9:3000000", "21,26,30,31,32,33:5000", "21,26,30,43,44,45:0"}, delimiter = ':')
    void whenCalculate_thenLottoResults(String winningNumberText, double expectedTotalMoney) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto winningLotto = lottoGenerator.generate(winningNumberText);

        LottoResults lottoResults = this.lottoCalculator.calculate(winningLotto, this.lottos);

        assertThat(lottoResults.count()).isEqualTo(4);
        assertThat(lottoResults.getTotalMoney()).isEqualTo(expectedTotalMoney);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,9:3000000", "21,26,30,31,32,33:5000", "21,26,30,43,44,45:0"}, delimiter = ':')
    void whenShowRate_thenLottoResults(String winningNumberText, double expectedTotalMoney) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto winningLotto = lottoGenerator.generate(winningNumberText);

        LottoResults lottoResults = this.lottoCalculator.calculate(winningLotto, this.lottos);

        assertThat(lottoResults.count()).isEqualTo(4);
        assertThat(lottoResults.getTotalMoney()).isEqualTo(expectedTotalMoney);
    }
}