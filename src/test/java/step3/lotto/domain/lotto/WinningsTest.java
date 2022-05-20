package step3.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
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
    @DisplayName("N번의 로또 게임의 당첨 통계 반환")
    public void returnMatchResults_GivenLottos() {
        // Given
        Lottos lottos = new Lottos(Arrays.asList(
            Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7)),
            Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 8)),
            Lotto.of(Arrays.asList(1, 2, 3, 4, 7, 8)),
            Lotto.of(Arrays.asList(1, 2, 3, 7, 8, 9)),
            Lotto.of(Arrays.asList(1, 2, 7, 8, 9, 10)),
            Lotto.of(Arrays.asList(1, 7, 8, 9, 10, 11)),
            Lotto.of(Arrays.asList(7, 8, 9, 10, 11, 12))
        ));
        Lotto winningsLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.of(7);
        Winnings winnings = Winnings.of(winningsLotto, lottoNumber);

        // When
        MatchStatistic matchStatistic = winnings.match(lottos);

        // Then
        assertAll(
            () -> assertThat(matchStatistic.getFirstPlaceCount()).as("6개 일치 수").isEqualTo(1),
            () -> assertThat(matchStatistic.getSecondPlaceCount()).as("5개 일치 수").isEqualTo(1),
            () -> assertThat(matchStatistic.getThirdPlaceCount()).as("4개 일치 수").isEqualTo(1),
            () -> assertThat(matchStatistic.getForthPlaceCount()).as("3개 일치 수").isEqualTo(1),
            () -> assertThat(matchStatistic.getRateOfProfit()).as("수익률").isEqualTo(250569.37)
        );
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
