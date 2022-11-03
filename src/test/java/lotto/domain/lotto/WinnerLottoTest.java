package lotto.domain.lotto;

import lotto.status.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class WinnerLottoTest {

    @Test
    @DisplayName("당첨로또 번호와 보너스볼을 가진 WinnerLotto볼을 생성 할 수 있다.")
    void create_winner_lotto() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        LottoNumber bonus = new LottoNumber(10);
        assertThatCode(() -> new WinnerLotto(lottoNumbers, bonus)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨로또 번호의 로또 번호 개수가 6이 아닌 경우 생성실패")
    void create_winner_lotto_lott_number_size_error() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5).map(LottoNumber::new).collect(Collectors.toList());
        LottoNumber bonus = new LottoNumber(10);
        assertThatIllegalArgumentException().isThrownBy(() -> new WinnerLotto(lottoNumbers, bonus))
                .withMessage(ErrorStatus.INVALID_LOTTO_COMPONENT.getMessage());
    }


    @Test
    @DisplayName("당첨로또 번호와 보너스볼을 가진 WinnerLotto볼을 생성 시 당첨로또 번호에 보너스볼이 포함되어 있으면 생성 실패")
    void validate_lotto_numbers_and_bonusNumber() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        LottoNumber bonus = new LottoNumber(1);
        assertThatIllegalArgumentException().isThrownBy(() -> new WinnerLotto(lottoNumbers, bonus))
                .withMessage(ErrorStatus.INVALID_BONUS_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("보너스 볼의 숫자와 구매한 로또 번호가 일치하는지 테스트")
    @CsvSource(value = {"7:true", "8:true", "9:false"}, delimiter = ':')
    void match_bonus_number_and_buy_lotto_number(int bonusNumber, boolean expect) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        WinnerLotto winnerLotto = new WinnerLotto(lottoNumbers, new LottoNumber(bonusNumber));
        assertThat(winnerLotto.matchBonusNumber(new Lotto(Stream.of(1,2,3,7,8,5).map(LottoNumber::new
        ).collect(Collectors.toList())))).isEqualTo(expect);
    }

    @Test
    @DisplayName("당첨 로또 번호에 구매한 로또 번호가 포함 true 테스트")
    void match_winner_lotto_number_contain_buy_lotto_number_true() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        LottoNumber bonus = new LottoNumber(7);
        WinnerLotto winnerLotto = new WinnerLotto(lottoNumbers, bonus);
        assertThat(winnerLotto.containLottoNumber(new LottoNumber(1))).isTrue();
    }

    @Test
    @DisplayName("당첨 로또 번호에 구매한 로또 번호가 포함 false 테스트")
    void match_winner_lotto_number_contain_buy_lotto_number_false() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        LottoNumber bonus = new LottoNumber(7);
        WinnerLotto winnerLotto = new WinnerLotto(lottoNumbers, bonus);
        assertThat(winnerLotto.containLottoNumber(new LottoNumber(10))).isFalse();
    }
}
