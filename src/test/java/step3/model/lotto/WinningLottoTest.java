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

    private Lotto lotto;
    private LottoNumber bonusNumber;
    private WinningLotto winningLotto;

    private List<LottoNumber> changeToLottoNumbers(List<Integer> numbers){
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
    @BeforeEach
    void setup() {
        List<LottoNumber> lottoNumbers = changeToLottoNumbers(Arrays.asList(1,2,3,4,5,6));
        lotto = new Lotto(lottoNumbers);
        bonusNumber = new LottoNumber(7);
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void 보너스_번호_중복_에러(int input) {
        LottoNumber newBonusNumber = new LottoNumber(input);
        assertThatThrownBy(() -> new WinningLotto(lotto, newBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과_매칭_검증_2등() {
        List<LottoNumber> secondWinningLottoNumbers = changeToLottoNumbers(Arrays.asList(1,2,3,4,5,8));
        Lotto secondWinningLotto = new Lotto(secondWinningLottoNumbers);
        assertThat(winningLotto.getMatchResult(secondWinningLotto)).isEqualTo(Result.SECOND_PRIZE);
    }

    @Test
    void 결과_매칭_검증_2등_보너스() {
        List<LottoNumber> secondBonusLottoNumbers = changeToLottoNumbers(Arrays.asList(1,2,3,4,5,7));
        Lotto secondBonusLotto = new Lotto(secondBonusLottoNumbers);
        assertThat(winningLotto.getMatchResult(secondBonusLotto)).isEqualTo(Result.SECOND_PRIZE_BONUS);
    }
    @Test
    void 이등_외에는_보너스_상관없음() {
        Lotto thirdWinnerBonusLotto = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,7,8)));
        Lotto thirdWinnerNoBonusLotto = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,8,9)));
        assertThat(winningLotto.getMatchResult(thirdWinnerBonusLotto))
                .isEqualTo(winningLotto.getMatchResult(thirdWinnerNoBonusLotto));
    }

}