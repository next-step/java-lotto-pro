package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Lotto;
import step3.model.LottoGame;
import step3.model.LottoGenerator;
import step3.model.LottoNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator = new LottoGenerator();
    private LottoGame lottoGame = new LottoGame();

    private int count15 = 15000;
    private int count10 = 10900;
    private int below1000 = 900;

    @Test
    @DisplayName("구매금액은 숫자로만 이루어져야 한다")
    void purchase_price_only_number() {
        String onlyNumberPrice = "5000";
        String notOnlyNumberPrice = "5000원";

        assertThat(lottoGame.convertIntegerByInputString(onlyNumberPrice)).isEqualTo(5000);
        assertThatThrownBy(() -> lottoGame.convertIntegerByInputString(notOnlyNumberPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 구매금액에서 1장에 1000원으로 계산된 구입 가능한 최대 로또 개수를 계산해야 한다" +
            "1000원 단위가 아니라면 최대 가능 개수를 계산하고, 1000원 이하의 금액이 들어오면 0개를 구매할 수 있다")
    void calculator_max_lotto_purchase_count() {
        assertThat(lottoGenerator.getGeneratorCount(count15, 0)).isEqualTo(15);
        assertThat(lottoGenerator.getGeneratorCount(count10, 0)).isEqualTo(10);
        assertThat(lottoGenerator.getGeneratorCount(below1000, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("발급된 로또는 총 6개의 1~45사이의 랜덤한 숫자로 발급이 되어야한다.")
    void validation_generator_lotto_number() {
        List<Lotto> lottos = lottoGenerator.generateLottos(3000, 0).getLottos();

        for (Lotto lotto : lottos) {
            checkLottoSizeIs6(lotto);
            checkLottoNumberBetween1To45(lotto);
        }
    }

    private void checkLottoSizeIs6(Lotto lotto) {
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    private void checkLottoNumberBetween1To45(Lotto lotto) {
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            assertThat(lottoNumber.value()).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("구입 가능한 개수만큼 로또가 발급되어야 한다")
    void generator_lotto_count() {
        assertThat(lottoGenerator.generateLottos(count15, 0).getSize()).isEqualTo(15);
        assertThat(lottoGenerator.generateLottos(count10, 0).getSize()).isEqualTo(10);
        assertThat(lottoGenerator.generateLottos(below1000, 0).getSize()).isEqualTo(0);
    }

}
