package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.Rank;
import step3.domain.WinningBonusNumber;

public class LottoTest {
    private static ArrayList<Integer> lottoNumbers;
    private static WinningBonusNumber winningBonusNumber;
    
    @BeforeAll
    static void beforeAll() {
        lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningBonusNumber = new WinningBonusNumber("2, 3, 4, 5, 6, 7","1");
    }
    
    @Test
    @DisplayName("로또 객체 생성")
    public void lotto_create_object() {
        assertThat(new Lotto(lottoNumbers)).isEqualTo(new Lotto(lottoNumbers));
    }
    
    @Test
    @DisplayName("로또 객체에서 당첨번호가 포함되는지 매칭")
    public void lotto_match_winningNumber() {
        LottoNumber winningNumber = new LottoNumber("5");
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.matchNumber(winningNumber)).isEqualTo(true);
    }
    
    @Test
    @DisplayName("당첨번호와 같은 숫자가 몇개 있는지 검증")
    public void lotto_compare_count() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(winningBonusNumber.getMatchCount(lotto)).isEqualTo(5);
    }
    
    @Test
    @DisplayName("로또 번호와 당첨번호를 비교하여 순위 및 당첨금 확인")
    void lotto_match_prize() {
        Lotto lotto = new Lotto(lottoNumbers);
        int count = winningBonusNumber.getMatchCount(lotto);
        assertThat(Rank.valueOf(count, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(count, false).getPrize()).isEqualTo(Rank.THIRD.getPrize());
    }

    @Test
    @DisplayName("로또 객체에서 보너스번호가 포함되는지 매칭")
    public void lotto_match_bonusNumber() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(winningBonusNumber.checkBonusNumber(lotto)).isEqualTo(true);
    }

    @Test
    @DisplayName("문자열로 당첨번호 생성")
    public void lotto_Create_String() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(lotto2);
    }

}
