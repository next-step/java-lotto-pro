package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        LottoNumber[] lottoNumbers = createNumbers(new int[]{1, 2, 3, 4, 5, 6});
        lotto = new Lotto(lottoNumbers);
    }

    @ParameterizedTest
    @MethodSource("winningLottoAndExpectedMatchResult")
    void 로또번호와_당첨번호에_따른_매치결과_반환(WinningLotto winningLotto, MatchResult expect) {
        assertThat(winningLotto.isMatched(lotto, expect)).isEqualTo(true);
    }

    @Test
    void 중복_숫자_예외() {
        assertThatThrownBy(
                () -> createWinningLotto(new int[]{1, 2, 3, 4, 5, 6}, 1)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 보너스_중복_숫자_예외() {

        assertThatThrownBy(
                () -> createWinningLotto(new int[]{1, 2, 3, 4, 5, 6}, 1)).isInstanceOf(
                IllegalArgumentException.class);
    }

    static private LottoNumber[] createNumbers(int[] inputs) {
        LottoNumber[] lottoNumbers = new LottoNumber[inputs.length];
        for (int index = 0; index < inputs.length; index++) {
            lottoNumbers[index] = LottoNumber.from(inputs[index]);
        }
        return lottoNumbers;
    }

    static private WinningLotto createWinningLotto(int[] inputs, int bonusNumber) {
        LottoNumber[] lottoNumbers = new LottoNumber[inputs.length];
        for (int index = 0; index < inputs.length; index++) {
            lottoNumbers[index] = LottoNumber.from(inputs[index]);
        }
        return new WinningLotto(lottoNumbers, LottoNumber.from(bonusNumber));
    }

    static private Stream<Arguments> winningLottoAndExpectedMatchResult() {
        return Stream.of(
                Arguments.of(createWinningLotto(new int[]{1, 2, 3, 4, 5, 6}, 45), MatchResult.of(6, false)),
                Arguments.of(createWinningLotto(new int[]{1, 2, 3, 4, 5, 45}, 6), MatchResult.of(5, true)),
                Arguments.of(createWinningLotto(new int[]{1, 2, 3, 4, 5, 7}, 45), MatchResult.of(5, false)),
                Arguments.of(createWinningLotto(new int[]{1, 2, 3, 4, 7, 8}, 45), MatchResult.of(4, false)),
                Arguments.of(createWinningLotto(new int[]{1, 2, 3, 7, 8, 9}, 45), MatchResult.of(3, false)),
                Arguments.of(createWinningLotto(new int[]{1, 2, 7, 8, 9, 10}, 45), MatchResult.of(2, false)),
                Arguments.of(createWinningLotto(new int[]{1, 7, 8, 9, 10, 11}, 45), MatchResult.of(1, false)),
                Arguments.of(createWinningLotto(new int[]{7, 8, 9, 10, 11, 12}, 45), MatchResult.of(0, false))
        );
    }
}