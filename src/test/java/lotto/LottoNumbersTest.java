package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.strategy.AutoPickNumberStrategy;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    public void differentSixNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<LottoNumber> lottoNumberList = lottoNumbers.makeLottoNumbers(new AutoPickNumberStrategy());
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumberList);
        assertThat(lottoNumberSet).hasSize(6);
    }

}
