package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    @Test
    void 로또들의_총_수입금_반환() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,5,6")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,3,4,5,6,7")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("4,8,10,23,32,45"))));
        Lotto winningLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,8,10"));
        LottoResults lottoResults = lottos.createLottoResults(winningLotto);
        assertThat(lottoResults.findProfits()).isEqualTo(new Money(60000));
    }

    @Test
    void 로또들의_상금별_개수_반환() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,5,6")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,3,4,5,6,7")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("4,8,10,23,32,45"))));
        Lotto winningLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,8,10"));
        LottoResults lottoResults = lottos.createLottoResults(winningLotto);
        assertAll(
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.FOURTH)).isEqualTo(2),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.THIRD)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.FIRST)).isZero()
        );
    }
}
