package step3.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.machine.Result;

class WinningLottoTest {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();
    private WinningLotto winningLotto;

    private List<LottoNumber> changeToLottoNumbers(List<Integer> numbers){
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
    @BeforeEach
    void setup() {
        lottoNumbers = changeToLottoNumbers(Arrays.asList(1,2,3,4,5,6));
        winningLotto = new WinningLotto(lottoNumbers, new LottoNumber(7));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void 보너스_번호_중복_에러(int input) {
        LottoNumber bonusNumber = new LottoNumber(input);
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과_매칭_검증_2등() {
        Lotto second_winner_lotto = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,5,8)));
        assertThat(winningLotto.getMatchResult(second_winner_lotto)).isEqualTo(Result.SECOND_PRIZE);
    }

    @Test
    void 결과_매칭_검증_2등_보너스() {
        Lotto second_bonus_lotto = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,5,7)));
        assertThat(winningLotto.getMatchResult(second_bonus_lotto)).isEqualTo(Result.SECOND_PRIZE_BONUS);
    }
    @Test
    void 이등_외에는_보너스_상관없음() {
        Lotto third_winner_match_bonus = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,7,8)));
        Lotto third_winner_no_match_bonus= new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,8,9)));
        assertThat(winningLotto.getMatchResult(third_winner_match_bonus))
                .isEqualTo(winningLotto.getMatchResult(third_winner_no_match_bonus));
    }

}