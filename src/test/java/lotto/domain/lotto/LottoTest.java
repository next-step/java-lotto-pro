package lotto.domain.lotto;

import lotto.generate.LottoNumberGenerator;
import lotto.status.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @ParameterizedTest
    @MethodSource("lottoNumbers")
    @DisplayName("LottoNumber 리스트를 가진 로또 클레스 생성")
    void create_lotto(List<LottoNumber> lottoNumbers) {
        Lotto expect = new Lotto(lottoNumbers);
        assertThat(new Lotto(lottoNumbers)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("errorLottoNumbers")
    @DisplayName("로또 클레스 생성시 매개변수로 받는 LottoNumber의 리스트의 원소 개수가 6이 아닌경우 ArgumentException 발생")
    void create_lotto_throw_argumentException(List<LottoNumber> lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumbers)).withMessage(ErrorStatus.INVALID_LOTTO_COMPONENT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("당첨 로또와 자기가 구매한 로또번호들과 비교하여 일치하는 개수 반환")
    @MethodSource("lottoCompareWinnerLotto")
    void match_lotto_number_compare_winn_lotto(Lotto lotto, WinnerLotto winnerLotto, int expect) {
        assertThat(lotto.matchCount(winnerLotto)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 중 보너스 볼과 일치하는게 있다면 true 반환")
    @MethodSource("lottoHasBonusNumberReturnTrue")
    void match_bonus_number_return_true(Lotto lotto, WinnerLotto winnerLotto) {
        boolean hasBonusNumber = lotto.hasBonusNumber(winnerLotto);
        assertThat(hasBonusNumber).isTrue();
    }

    @ParameterizedTest
    @DisplayName("로또 번호 중 보너스 볼과 일치하는게 없다면 false 반환")
    @MethodSource("lottoHasBonusNumberReturnFalse")
    void match_bonus_number_return_false(Lotto lotto, WinnerLotto winnerLotto, boolean expect) {
        boolean hasBonusNumber = lotto.hasBonusNumber(winnerLotto);
        assertThat(hasBonusNumber).isFalse();
    }

    private static Stream<List<LottoNumber>> lottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();
        return Stream.of(
                lottoNumbers
        );
    }

    private static Stream<List<LottoNumber>> errorLottoNumbers() {
        return Stream.of(
                Stream.iterate(1, n -> n + 1).limit(7).map(LottoNumber::new).collect(Collectors.toList()),
                Stream.iterate(1, n -> n + 1).limit(3).map(LottoNumber::new).collect(Collectors.toList())
        );
    }

    private static Stream<Arguments> lottoCompareWinnerLotto() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 20, 3, 5, 4, 7).map(LottoNumber::new).collect(Collectors.toList());
        LottoNumber bonus = new LottoNumber(45);
        return Stream.of(
                Arguments.of(new Lotto(lottoNumbers), new WinnerLotto(winnerLottoNumbers, bonus), 4)
        );
    }

    private static Stream<Arguments> lottoHasBonusNumberReturnTrue() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 20, 3, 5, 4, 7).map(LottoNumber::new).collect(Collectors.toList());
        LottoNumber bonus = new LottoNumber(2);
        return Stream.of(
                Arguments.of(new Lotto(lottoNumbers), new WinnerLotto(winnerLottoNumbers, bonus), true)
        );
    }

    private static Stream<Arguments> lottoHasBonusNumberReturnFalse() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 20, 3, 5, 4, 7).map(LottoNumber::new).collect(Collectors.toList());
        LottoNumber bonus = new LottoNumber(45);
        return Stream.of(
                Arguments.of(new Lotto(lottoNumbers), new WinnerLotto(winnerLottoNumbers, bonus), false)
        );
    }
}
