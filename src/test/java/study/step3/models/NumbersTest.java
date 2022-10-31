package study.step3.models;

import org.junit.jupiter.api.Test;
import study.step3.exception.LottoConsistOfSameNumbersException;
import study.step3.exception.LottoNumberListSizeException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class NumbersTest {
    @Test
    void 번호가_일치하는_갯수_구하기() {
        Numbers winLottoNumbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Numbers lottoNumbers = new Numbers(Arrays.asList(1, 3, 4, 5, 6, 8));

        int countOfMatch = lottoNumbers.countNumberOfMatching(winLottoNumbers);

        assertThat(countOfMatch).isEqualTo(5);
    }

    @Test
    void 로또_숫자_만들기() {
        assertThatNoException().isThrownBy(() -> new Lotto(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 로또_숫자_리스트_크기_예외() {
        // 숫자 5개
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(LottoNumberListSizeException.class);
        // 숫자 7개
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(LottoNumberListSizeException.class);
    }

    @Test
    void 로또_숫자_서로_다른_수_구성_예외() {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 1, 3, 4, 5, 6)))
                .isInstanceOf(LottoConsistOfSameNumbersException.class);
    }
}
