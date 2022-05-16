package lotto.model.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @Test
    @DisplayName("로또사이즈에 따라 로또 리스트가 출력되는지 확인")
    void 로또사이즈에_따른_로또_리스트_출력() {
        List<Lotto> lottoNumbers = new LottoTestFactory().generateAuto(2);

        assertThat(lottoNumbers).hasSize(2);
    }

}
