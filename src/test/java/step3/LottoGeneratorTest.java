package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoShop;
import step3.domain.LottoNumbers;
import step3.domain.LottoGenerator;
import step3.domain.Lottos;
import step3.domain.RandomGenerateStrategy;

public class LottoGeneratorTest {

    RandomGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();
    LottoShop lottoGenerator = new LottoShop(randomGenerateStrategy);

    @Test
    @DisplayName("입력된 숫자만큼 로또를 생성해주는 테스트")
    void makeLottos() {

        Lottos lottos = lottoGenerator.createLottos(6);
        assertThat(lottos.getLottoList().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수동으로 입력받은 숫자를 로또로 만들어주는 테스트")
    void stringToLotto() {
        String lottoNumbers = "1,2,3,4,5,6";
        Lotto lotto = LottoGenerator.create(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(new LottoNumbers(lottoNumbers)));
    }
}
