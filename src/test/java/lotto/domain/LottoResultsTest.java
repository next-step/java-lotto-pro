package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    @Test
    void 로또들의_총_수입금_반환() {
        Lottos lottos = createLottos();
        Lotto winningLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,8,10"));
        LottoNumber bonusLottoNumber = LottoNumber.from(34);
        LottoResults lottoResults = lottos.createLottoResults(new WinningLotto(winningLotto, bonusLottoNumber));
        assertThat(lottoResults.findProfits()).isEqualTo(Money.createMoney(60000L));
    }

    @Test
    void 로또들의_총_수입금_없음() {
        Lottos lottos = createLottos();
        Lotto winningLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,8,10,14,24"));
        LottoNumber bonusLottoNumber = LottoNumber.from(34);
        LottoResults lottoResults = lottos.createLottoResults(new WinningLotto(winningLotto, bonusLottoNumber));
        assertThat(lottoResults.findProfits()).isEqualTo(Money.createMoney(0));
    }

    @Test
    void 로또들의_상금별_개수_반환() {
        Lottos lottos = createLottos();
        Lotto winningLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,5,10"));
        LottoNumber bonusLottoNumber = LottoNumber.from(34);
        LottoResults lottoResults = lottos.createLottoResults(new WinningLotto(winningLotto, bonusLottoNumber));
        assertAll(
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.FOURTH)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.THIRD)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.FIRST)).isZero()
        );
    }

    private Lottos createLottos() {
        return new Lottos(Arrays.asList(
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,5,6")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,3,4,5,6,7")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("4,8,10,23,32,45"))));
    }
}
