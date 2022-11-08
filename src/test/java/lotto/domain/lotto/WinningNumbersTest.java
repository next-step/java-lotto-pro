package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

class WinningNumbersTest {
    @DisplayName("당첨 번호는 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 당첨_번호_null(final LottoNumbers winningNumbers) {
        final LottoNumber bonus = new LottoNumber(7);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(winningNumbers, bonus))
                .withMessage("당첨 번호는 null이 아니어야 합니다.");
    }


    @DisplayName("보너스는 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 보너스_null(final LottoNumber bonus) {
        final LottoNumbers winningNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(winningNumbers, bonus))
                .withMessage("보너스는 null이 아니어야 합니다.");
    }

    @DisplayName("당첨번호와 보너스가 모두 일치하면 동일한 객체이다.")
    @Test
    void 동일성() {
        final WinningNumbers one = new WinningNumbers(new LottoNumbers(1, 2, 3, 4, 5, 6), new LottoNumber(7));
        final WinningNumbers another = new WinningNumbers(new LottoNumbers(1, 2, 3, 4, 5, 6), new LottoNumber(7));

        assertThat(one).isEqualTo(another);
    }

    @ParameterizedTest(name = "당첨번호 1,2,3,4,5,6이고 보너스 7일 때, 내 로또가 [{0},{1},{2},{3},{4},{5}]이면, [{6}]")
    @CsvSource({
            "1,2,3,4,5,6,SIX",
            "1,2,3,4,5,7,FIVE_WITH_BONUS",
            "1,2,3,4,5,45,FIVE",
            "1,2,3,4,44,45,FOUR",
            "1,2,3,43,44,45,THREE",
            "1,2,42,43,44,45,BLANK",
            "1,41,42,43,44,45,BLANK",
            "40,41,42,43,44,45,BLANK",
    })
    void 당첨_여부(
            final int no1,
            final int no2,
            final int no3,
            final int no4,
            final int no5,
            final int no6,
            final Matches expected
    ) {
        final Lotto myLotto = new Lotto(no1, no2, no3, no4, no5, no6);
        final WinningNumbers winningNumbers = new WinningNumbers(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumber(7)
        );

        final Matches actual = winningNumbers.match(myLotto);

        assertThat(actual).isEqualTo(expected);
    }
}
