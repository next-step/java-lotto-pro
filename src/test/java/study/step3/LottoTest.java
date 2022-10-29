package study.step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_만들기() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.makeLotto();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 당첨_번호와_일치하는_갯수_구하기() {
        // given
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(Arrays.asList(1, 3, 4, 5, 6, 8));

        // when
        int matchingNumber = lotto.compare(winNumbers);

        // then
        assertThat(matchingNumber).isEqualTo(5);
    }
}
