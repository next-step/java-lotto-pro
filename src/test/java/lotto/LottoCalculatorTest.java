package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoCalculator 테스트")
public class LottoCalculatorTest {

    private LottoCalculator lottoCalculator;

    @BeforeEach
    void setUp() {
        lottoCalculator = new LottoCalculator(new PurchaseAmount(10_000));
    }

    @Test
    @DisplayName("구입된 로또 개수를 반환한다.")
    void getLottosSize() {
        // when
        int lottosSize = lottoCalculator.getLottosSize();

        // then
        assertThat(lottosSize).isEqualTo(10_000 / LottoCalculator.LOTTO_PRICE);
    }

    @Test
    @DisplayName("로또 리스트를 출력한다.")
    void printLottos() {
        lottoCalculator.printLottos();
    }

    @Test
    @DisplayName("당첨 통계를 출력한다.")
    void printStats() {
        // given
        lottoCalculator.calculate(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // when
        lottoCalculator.printStats();
    }
}
