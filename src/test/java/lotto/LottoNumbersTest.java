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
        //given
        List<LottoNumber> numberList = new AutoPickNumberStrategy().pickLottoNumbers();
        LottoNumbers lottoNumbers = new LottoNumbers(numberList);
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers.getValues());
        int expectedSize = 6;

        //when
        int actualSize = lottoNumberSet.size();

        //then
        assertThat(actualSize).isEqualTo(expectedSize);
    }
}