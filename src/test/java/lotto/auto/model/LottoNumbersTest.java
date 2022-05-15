package lotto.auto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 숫자가 중복될 경우 에러 출력")
    void 로또_숫자가_중복될_경우() {
        List<LottoNumber> lottoNumbers = generateLottoNumberList(new int[]{1, 2, 2, 3, 4, 5});

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @Test
    @DisplayName("로또 숫자가 설정값과 다를경우 에러 출력")
    void 숫자개수가_일치하지_않을_경우() {
        List<LottoNumber> lottoNumbers = generateLottoNumberList(new int[]{1, 2});

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    private List<LottoNumber> generateLottoNumberList(int[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

}
