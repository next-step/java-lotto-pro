package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoNumberTest {

    @Test
    @DisplayName("생성한 당첨 번호 객체 검증")
    void verifyWinningLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of("1,2,3,4,5,6"));
        Number number = Number.of(9);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(lottoNumber, number);

        assertAll(
                () -> assertThat(winningLottoNumber).isNotNull(),
                () -> assertEquals(new WinningLottoNumber(lottoNumber, number), winningLottoNumber)
        );
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복되면 IllegalArgumentException이 발생")
    void duplicateBonusNumberWithLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of("1,2,3,4,5,6"));
        Number number = Number.of(6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumber(lottoNumber, number))
                .withMessage("당첨 번호와 보너스 번호가 중복됩니다.");
    }

    @Test
    @DisplayName("5개 번호만 일치했을 때 3등을 반환하는지 검증")
    void verifyMatchLottoThirdRank() {
        LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of("1,2,3,4,5,6"));
        Number number = Number.of(9);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(lottoNumber, number);
        LottoNumber pickLottoNumber = new LottoNumber(
                Arrays.asList(
                        Number.of(1), Number.of(2), Number.of(3),
                        Number.of(4), Number.of(5), Number.of(15)
                )
        );

        assertEquals(LottoRank.THIRD, winningLottoNumber.matchLottoRank(pickLottoNumber));
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가일치 했을 때 2등을 반환하는지 검증")
    void verifyMatchLottoSecondRank() {
        LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of("1,2,3,4,5,6"));
        Number number = Number.of(9);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(lottoNumber, number);
        LottoNumber pickLottoNumber = new LottoNumber(
                Arrays.asList(
                        Number.of(1), Number.of(2), Number.of(3),
                        Number.of(4), Number.of(5), Number.of(9)
                )
        );

        assertEquals(LottoRank.SECOND, winningLottoNumber.matchLottoRank(pickLottoNumber));
    }
}
