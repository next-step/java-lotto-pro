package step3.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static step3.lotto.domain.lotto.Winnings.BONUS_NUMBER_ALREADY_EXIST_IN_WINNING_LOTTO_ERROR;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/18 6:46 오후
 */
@DisplayName("Domain:Winnings")
public class WinningsTest {

    @Test
    @DisplayName("지난주 당첨 번호와 보너스 번호를 가지는 당첨 번호 객체 생성 검증")
    public void createWinningsTest() {
        // Given
        Lotto winningsLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(7);

        // When
        Winnings winnings = Winnings.of(winningsLotto, bonusNumber);

        // Then
        assertThat(winnings).isNotNull();
    }

    @Test
    @DisplayName("보너스 번호가 지난주 당첨 번호에 포함 되는 경우 예외 발생 검증")
    public void throwException_WhenBonusNumberAlreadyExistInWinningsLotto() {
        // Given
        Lotto winningsLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(6);

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Winnings.of(winningsLotto, bonusNumber))
            .withMessageMatching(BONUS_NUMBER_ALREADY_EXIST_IN_WINNING_LOTTO_ERROR);
    }
}
