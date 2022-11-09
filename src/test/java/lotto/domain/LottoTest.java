package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("Lotto 정상 생성")
    public void Lotto_정상생성() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 6, 10, 20, 34, 45));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.lottoNumbers()).containsExactly(1, 6, 10, 20, 34, 45);
    }

    @Test
    @DisplayName("Lotto 6개의 숫자로 초과 시, 예외가 발생해야 한다.")
    public void Lotto_6개_초과() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 45, 32));
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 6개의 숫자로 미만 시, 예외가 발생해야 한다.")
    public void Lotto_6개_미만() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34));
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 6개의 숫자 중 중복된 숫자가 있으면 예외가 발생해야 한다.")
    public void Lotto_숫자_중복() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 6));
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 내 6개의 숫자는 오름차순으로 정렬되어 있다.")
    public void Lotto_숫자_정렬() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 45));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.lottoNumbers()).containsExactly(1, 6, 10, 20, 34, 45);
    }

    @Test
    @DisplayName("Lotto 내 기준 Lotto 와 bonus 일치에 따른 rank 반환")
    public void Lotto_match_count() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 45));
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 20, 30, 40, 34, 45));
        Lotto lotto = new Lotto(numbers);
        Lotto winLotto = new Lotto(winNumbers);
        LottoNumber bonus = new LottoNumber(1);
        assertThat(lotto.findRank(winLotto, bonus)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("Lotto Bonus 숫자와 당첨 번호 중복 시, 에러 발생")
    public void Lotto_bonus_숫자_duplicate_win_lottos_에러_발생() {
        assertThatThrownBy(() -> {
            List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 20, 30, 40, 34, 45));
            Lotto winLotto = new Lotto(winNumbers);
            LottoNumber bonus = new LottoNumber(1);
            winLotto.duplicateWinBonus(bonus);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
