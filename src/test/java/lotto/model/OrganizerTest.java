package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrganizerTest {

    Organizer organizer;

    @BeforeEach
    private void setup() {
        LottoNumbersInput numbersInput = new LottoNumbersInput("1, 12, 21, 33, 41, 45");
        WinningNumber winningNumber = new WinningNumber(numbersInput);
        organizer = new Organizer(
                winningNumber,
                new BonusNumber(7, winningNumber)
        );
    }

    @Test
    @DisplayName("로또 당첨 결과 정상 확인")
    public void checkWinningResults() {
        Lottos lottos = new Lottos(
                new Lotto[]{new Lotto(1, 12, 21, 3, 4, 5)}
        );
        assertThat(organizer.winningResults(lottos).get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 결과 2등 정상 확인")
    public void checkWinningSecondResults() {
        Lottos lottos = new Lottos(
                new Lotto[]{new Lotto(1, 7, 12, 21, 33, 41)}
        );
        assertThat(organizer.winningResults(lottos).get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 수익률 계산 정상 동작 확인")
    public void checkRateOfReturn() {
        Lottos lottos = new Lottos(
                new Lotto[]{new Lotto(1, 12, 21, 3, 4, 5)}
        );
        organizer.winningResults(lottos);
        assertThat(organizer.winningRate(15000)).isEqualTo("0.33");
    }
}

