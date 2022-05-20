package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.strategy.AutoPickNumberStrategy;
import org.junit.jupiter.api.Test;

public class LottoTest {
    
    @Test
    public void makeDifferentNumberLotto() {
        //given
        Lotto lotto = new Lotto(new AutoPickNumberStrategy());
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lotto.getNumbers().getValues());
        int expectedSize = 6;

        //when
        int actualSize = lottoNumberSet.size();

        //then
        assertThat(actualSize).isEqualTo(expectedSize);
    }
}
