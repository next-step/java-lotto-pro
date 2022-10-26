package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void lotto_generation() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }
    
    @Test
    @DisplayName("당첨번호와 같은 숫자라면 카운트를 올린다")
    public void lotto_compare_countUp() {
        Lotto lotto = new Lotto();
        int winningNumber = 5;
        int expect = 0;
        List<Integer> lottoNumber = lotto.getLottoNumbers();
        
        if(lottoNumber.contains((winningNumber))) {
            expect = 1;
        }
    
        lotto.compareCountUp(winningNumber);
        assertThat(lotto.getMatchCount()).isEqualTo(expect);
    }
    
    @Test
    @DisplayName("당첨번호와 같은 숫자가 몇개 있는지 검증")
    public void lotto_compare_count() {
        Lotto lotto = new Lotto();
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto.compareMath(winningNumbers);
        assertThat(lotto.getMatchCount()).isBetween(0,6);
    }
    
}
