package step3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private static ArrayList<Integer> lottoNumbers;
    private static WinningNumber winningNumber;
    
    @BeforeAll
    static void beforeAll() {
        lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningNumber = new WinningNumber("2, 3, 4, 5, 6, 7");
    }
    
    @Test
    @DisplayName("로또 객체 생성")
    public void lotto_create_object() {
        assertThat(new Lotto(lottoNumbers)).isEqualTo(new Lotto(lottoNumbers));
    }
    
    @Test
    @DisplayName("로또 객체에서 당첨번호가 포함되는지 매칭")
    public void lotto_match_winningNumber() {
        int winningNumber = 5;
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.match(winningNumber)).isEqualTo(true);
    }
    
    @Test
    @DisplayName("당첨번호와 같은 숫자가 있다면 카운트를 올린다")
    public void lotto_match_countUp() {
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.matchCountUp(5);
        assertThat(lotto.getMatchCount()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("당첨번호와 같은 숫자가 몇개 있는지 검증")
    public void lotto_compare_count() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.compareMath(winningNumber)).isEqualTo(5);
    }
    
    @Test
    @DisplayName("로또 번호와 당첨번호를 비교하여 순위 및 당첨금 확인")
    void lotto_match_prize() {
        Lotto lotto = new Lotto(lottoNumbers);
        int count = lotto.compareMath(winningNumber);
        assertThat(Rank.getRank(count)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getPrize(count)).isEqualTo(Rank.SECOND.getPrize());
    }
    
}
