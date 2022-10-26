package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Lotto;
import step3.model.LottoGenerator;
import step3.model.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator = new LottoGenerator();

    private String count15 = "15000";
    private String count10 = "10900";
    private String below1000 = "900";

    @BeforeEach
    void initLottoRangeList() {
        Lotto.initLottoNumberRangeList();
    }

    @Test
    @DisplayName("구매금액은 숫자로만 이루어져야 한다")
    void purchase_price_only_number() {
        String onlyNumberPrice = "5000";
        String notOnlyNumberPrice = "5000원";

        lottoGenerator.initPurchasePrice(onlyNumberPrice);
        assertThat(lottoGenerator.totalPurchasePrice()).isEqualTo(5000);
        assertThatThrownBy(() -> lottoGenerator.initPurchasePrice(notOnlyNumberPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 구매금액에서 1장에 1000원으로 계산된 구입 가능한 최대 로또 개수를 계산해야 한다" +
            "1000원 단위가 아니라면 최대 가능 개수를 계산하고, 1000원 이하의 금액이 들어오면 0개를 구매할 수 있다")
    void calculator_max_lotto_purchase_count() {
        lottoGenerator.initPurchasePrice(count15);
        assertThat(lottoGenerator.calculatorPurchaseCount()).isEqualTo(15);

        lottoGenerator.initPurchasePrice(count10);
        assertThat(lottoGenerator.calculatorPurchaseCount()).isEqualTo(10);

        lottoGenerator.initPurchasePrice(below1000);
        assertThat(lottoGenerator.calculatorPurchaseCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("발급된 한 건의 로또는 총 6개의 1~45사이의 랜덤한 숫자로 발급이 되어야한다.")
    void validation_generator_lotto_number() {
        Lotto lotto = lottoGenerator.generateLotto();

        assertThat(lotto.getGeneratorLottoCount()).isEqualTo(6);

        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("구입 가능한 개수만큼 로또가 발급되어야 한다")
    void generator_lotto_count() {
        lottoGenerator.initPurchasePrice(count15);
        lottoGenerator.calculatorPurchaseCount();
        assertThat(lottoGenerator.generateLottos().getSize()).isEqualTo(15);

        lottoGenerator.initPurchasePrice(count10);
        lottoGenerator.calculatorPurchaseCount();
        assertThat(lottoGenerator.generateLottos().getSize()).isEqualTo(10);

        lottoGenerator.initPurchasePrice(below1000);
        lottoGenerator.calculatorPurchaseCount();
        assertThat(lottoGenerator.generateLottos().getSize()).isEqualTo(0);
    }

}
