package lotto.utils;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoUtilsTest {

    @Test
    @DisplayName("LottoUtils 정상 반환")
    public void LottoUtils_정상반환() {
        String str = "10, 20, 30,40, 50, 60";
        assertThat(LottoUtils.stringToLottoNumbers(str)).containsExactly(10, 20, 30, 40, 50, 60);
    }

    @Test
    @DisplayName("LottoUtils 숫자가 아닌 값 입력 시, 에러 발생")
    public void LottoUtils_비숫자_에러_발생() {
        assertThatThrownBy(() -> {
            String str = "a, b, 30,40, 50";
            LottoUtils.stringToLottoNumbers(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoUtils money 숫자 아닌 값 입력 시, 에러 발생")
    public void LottoUtils_money_숫자_아닌_값_에러_발생() {
        assertThatThrownBy(() -> {
            String str = "aa";
            LottoUtils.stringToMoney(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoUtils Bonus 숫자 아닌 값 입력 시, 에러 발생")
    public void LottoUtils_bonus_숫자_아닌_값_에러_발생() {
        assertThatThrownBy(() -> {
            String str = "a,";
            LottoUtils.StringToBonusNumber(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoUtils Bonus 숫자와 당첨 번호 중복 시, 에러 발생")
    public void LottoUtils_bonus_숫자_duplicate_win_lottos_에러_발생() {
        assertThatThrownBy(() -> {
            List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 20, 30, 40, 34, 45));
            Lotto winLotto = new Lotto(winNumbers);
            LottoUtils.duplicateWinBonus(winLotto,1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
