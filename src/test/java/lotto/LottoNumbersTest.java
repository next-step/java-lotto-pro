package lotto;

import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    private static final List<LottoNumber> testLottoNumbers = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        testLottoNumbers.add(new LottoNumber(1));
        testLottoNumbers.add(new LottoNumber(2));
        testLottoNumbers.add(new LottoNumber(3));
        testLottoNumbers.add(new LottoNumber(4));
        testLottoNumbers.add(new LottoNumber(5));
        testLottoNumbers.add(new LottoNumber(6));
    }

    @Test
    void 번호_포함_여부() {
        LottoNumbers lottoNumbers = new LottoNumbers(testLottoNumbers);
        assertThat(lottoNumbers.contains(new LottoNumber(1))).isTrue();
    }

    @Test
    void 당첨_번호에게_로또_번호_6개가_동일한지_물어보기() {
        LottoNumbers lottoNumbers = new LottoNumbers(testLottoNumbers);
        LottoNumbers winningNumber = new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))));
        assertThat(winningNumber.countHit(lottoNumbers)).isEqualTo(FIRST.getCountOfMatch());
    }

    @Test
    void 당첨_번호에게_로또_번호_3개가_동일한지_물어보기() {
        LottoNumbers lottoNumbers = new LottoNumbers(testLottoNumbers);
        LottoNumbers winningNumber = new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(40),
                        new LottoNumber(50),
                        new LottoNumber(60))));
        assertThat(winningNumber.countHit(lottoNumbers)).isEqualTo(FIFTH.getCountOfMatch());
    }

    @Test
    void 로또_번호_출력() {
        assertThat(new LottoNumbers(testLottoNumbers).toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 몇등인지_물어보기() {
        LottoNumbers lottoNumbers = new LottoNumbers(testLottoNumbers);
        LottoNumbers winningNumber = new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6))));
        assertThat(lottoNumbers.getRank(winningNumber, new LottoNumber(7))).isEqualTo(FIRST);
    }
}