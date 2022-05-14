package lotto;

import java.util.Arrays;
import static java.util.stream.Collectors.*;

import java.util.List;
import lotto.factory.LottoNumbersFactory;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import static org.assertj.core.api.Assertions.*;

import lotto.number.WinLottoNumbers;
import org.junit.jupiter.api.Test;

public class WinLottoNumbersTest {

    private LottoNumbersFactory lottoNumbersFactory = new LottoNumbersFactory();

    @Test
    void 당첨번호와_보너스번호가_중복되는_경우_생성_실패(){
        String input = "11,22,23,33,43,4";
        List<Integer> numbers = Arrays.stream(input.split(",")).map((str)->Integer.parseInt(str)).collect(toList());
        LottoNumbers lottoNumbers = lottoNumbersFactory.createLottoNumbers(numbers);
        assertThatIllegalArgumentException().isThrownBy(()->{
            WinLottoNumbers.Builder.getInstance().lottoNumbers(lottoNumbers).bonusNumber(new LottoNumber(11)).build();
        });
    }
}
