package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void 로또들의_총_구입_금액_반환() {
        Lottos lottos = new Lottos(Money.createLottoMoney(5500L), new RandomLottoNumberGenerator());
        assertThat(lottos.findTotalPrice()).isEqualTo(Money.createLottoMoney(5000L));
    }

    @Test
    void 로또_결과_생성_시_각_등수별로_일치_개수가_존재() {
        Lottos lottos = createLottos();
        Lotto winningLotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,5,8"));
        LottoNumber bonusLottoNumber = LottoNumber.from(32);
        LottoResults lottoResults = lottos.createLottoResults(winningLotto, bonusLottoNumber);
        assertAll(
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.NO_PRIZE)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.FOURTH)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.THIRD)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.SECOND)).isZero()
        );
    }

    private Lottos createLottos() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,5,6")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,3,4,5,6,7")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("4,8,10,23,32,45"))));
        return lottos;
    }
}