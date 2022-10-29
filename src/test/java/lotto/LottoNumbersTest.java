package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    private static final List<LottoNumber> inputLottoNumbers = new ArrayList<>();

    @BeforeAll
    static void 초기화() {
        LottoNumber fakeGeneratedLottoNumber1 = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumber fakeGeneratedLottoNumber2 = new LottoNumber(new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12)));
        inputLottoNumbers.add(fakeGeneratedLottoNumber1);
        inputLottoNumbers.add(fakeGeneratedLottoNumber2);
    }

    @Test
    void 로또_번호_저장() {
        LottoNumbers lottoNumbers = new LottoNumbers(inputLottoNumbers);
        assertThat(lottoNumbers.countPurchase()).isEqualTo(2);
    }

    @Test
    void 로또_당첨_1등_확인() {
        LottoNumbers lottoNumbers = new LottoNumbers(inputLottoNumbers);
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers.countPrize(winningNumbers);
        assertThat(lottoNumbers.countFirst()).isEqualTo(1);
    }

    @Test
    void 로또_당첨_2등_확인() {
        LottoNumbers lottoNumbers = new LottoNumbers(inputLottoNumbers);
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 45));
        lottoNumbers.countPrize(winningNumbers);
        assertThat(lottoNumbers.countSecond()).isEqualTo(1);
    }

    @Test
    void 로또_당첨_3등_확인() {
        LottoNumbers lottoNumbers = new LottoNumbers(inputLottoNumbers);
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 44, 45));
        lottoNumbers.countPrize(winningNumbers);
        assertThat(lottoNumbers.countThird()).isEqualTo(1);
    }

    @Test
    void 로또_당첨_4등_확인() {
        LottoNumbers lottoNumbers = new LottoNumbers(inputLottoNumbers);
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 43, 44, 45));
        lottoNumbers.countPrize(winningNumbers);
        assertThat(lottoNumbers.countFourth()).isEqualTo(1);
    }
}
