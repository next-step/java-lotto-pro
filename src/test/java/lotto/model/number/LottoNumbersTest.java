package lotto.model.number;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 숫자가 중복될 경우 에러 출력")
    void 로또_숫자가_중복될_경우() {
        Set<LottoNumber> lottoNumbers = generateLottoNumberList(new int[]{1, 2, 2, 3, 4, 5});

        assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoNumbers.fromLottoNumberSet(lottoNumbers));
    }

    @Test
    @DisplayName("로또 숫자가 설정값과 다를경우 에러 출력")
    void 숫자개수가_일치하지_않을_경우() {
        Set<LottoNumber> lottoNumbers = generateLottoNumberList(new int[]{1, 2});

        assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoNumbers.fromLottoNumberSet(lottoNumbers));
    }

    @Test
    @DisplayName("로또숫자 안에 당첨번호가 포함되는지 확인한다.")
    void 로또숫자를_포함하는지_확인한다() {
        Set<LottoNumber> lottoNumberList = generateLottoNumberList(new int[]{1, 2, 3, 4, 5, 6});
        Set<LottoNumber> winningNumberList = generateLottoNumberList(new int[]{1, 2, 3, 7, 8, 9});
        LottoNumbers lottoNumbers = LottoNumbers.fromLottoNumberSet(lottoNumberList);
        LottoNumbers winningNumbers = LottoNumbers.fromLottoNumberSet(winningNumberList);

        int countContainLottoNumber = lottoNumbers.countContainLottoNumber(winningNumbers);
        assertEquals(countContainLottoNumber, 3);
    }

    private Set<LottoNumber> generateLottoNumberList(int[] numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

}
