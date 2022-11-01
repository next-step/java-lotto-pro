package lotto.domain;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
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
        LottoResults lottoResults = lottos.createLottoResults(new WinningLotto(winningLotto, bonusLottoNumber));
        assertAll(
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.NO_PRIZE)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.FOURTH)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.THIRD)).isEqualTo(1),
                () -> assertThat(lottoResults.findLottoResultCount(LottoPrize.SECOND)).isZero()
        );
    }

    @Test
    void 수동_로또_생성_개수_포함한_로또_개수_확인() {
        List<Lotto> manualLottos = Arrays.asList(
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,5,6")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("4,8,10,23,32,45")));
        Lottos lottos = Lottos.mergeLottos(5, new RandomLottoNumberGenerator(), new Lottos(manualLottos));
        assertThat(lottos.unmodifiedLottos()).hasSize(7);
    }

    @Test
    void 수동_로또가_비었을_때_로또_생성_테스트() {
        Lottos lottos = Lottos.mergeLottos(2, new ReadLineLottoNumberGenerator("1,2,3,4,5,6"), new Lottos(emptyList()));
        assertThat(lottos.unmodifiedLottos()).hasSize(2);
    }

    private Lottos createLottos() {
        return new Lottos(Arrays.asList(
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,2,3,4,5,6")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("1,3,4,5,6,7")),
                Lotto.generateLotto(new ReadLineLottoNumberGenerator("4,8,10,23,32,45"))));
    }
}