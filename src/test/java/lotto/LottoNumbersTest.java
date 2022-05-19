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
        List<LottoNumber> numberList = new AutoPickNumberStrategy().pickLottoNumbers();
        LottoNumbers lottoNumbers = new LottoNumbers(numberList);
        List<LottoNumber> lottoNumberList = lottoNumbers.getValues();
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumberList);
        assertThat(lottoNumberSet).hasSize(6);
    }
}
