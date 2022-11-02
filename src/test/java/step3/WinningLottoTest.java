package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Lotto;
import step3.model.LottoNumber;
import step3.model.WinningLotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step3.LottoUtils.getLottoNumbers;

public class WinningLottoTest {

    @Test
    @DisplayName("보너스볼이 중복되면 예외반환")
    void test_that_throw_exception_if_duplicate_bonus() {
        //given
        Lotto lotto = new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16));

        //when,then
        assertThatThrownBy(() -> new WinningLotto(lotto,LottoNumber.valueOf(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스번호는 고유한 번호만 허용합니다");
    }

    @Test
    @DisplayName("보너스볼이 로또번호에 포함되면 true반환")
    void test_that_it_returns_it_contains_bonusball() {
        //given
        Lotto lotto = new Lotto(getLottoNumbers(1, 2, 3, 14, 15, 16));

        //when
        WinningLotto winningLotto = new WinningLotto(lotto,LottoNumber.valueOf(27));
        List<LottoNumber> lottoNumbers = new Lotto(getLottoNumbers(1, 2, 3, 11, 27, 13)).getNumbers();

        //then
        assertThat(winningLotto.isMatchBonusNumber(lottoNumbers)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    @DisplayName("입력한 번호가 로또에 포함되면 true반환")
    void test_that_it_returns_numbers(int number) {
        //given
        Lotto lotto = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));

        //when
        WinningLotto winningLotto = new WinningLotto(lotto,LottoNumber.valueOf(27));

        //then
        assertThat(winningLotto.contains(LottoNumber.valueOf(number))).isTrue();
    }
}
