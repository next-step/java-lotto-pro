package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.LottoNumber;
import lotto.strategy.AutoPickNumberStrategy;
import org.junit.jupiter.api.Test;

public class LottoTest {


    @Test
    public void makeDifferentNumberLotto() {
        Lotto lotto = new Lotto(new AutoPickNumberStrategy());
        lotto.getNumbers().getValues();
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lotto.getNumbers().getValues());
        assertThat(lottoNumberSet).hasSize(6);
    }
}
