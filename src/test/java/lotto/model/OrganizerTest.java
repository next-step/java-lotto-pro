package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrganizerTest {

    Organizer organizer;
    Lotto winningLotto;

    @BeforeEach
    private void setup() {
        winningLotto = new Lotto("1, 12, 21, 33, 41, 45");
        organizer = new Organizer(
                winningLotto,
                new LottoNo(7)
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

    @Test
    @DisplayName("보너스 번호 비정상 값 검증")
    public void checkNotValidBonusNumber() {
        assertThatThrownBy(() -> {new Organizer(new Lotto(1, 2, 21, 3, 4, 5), new LottoNo(2));})
                .isInstanceOf(IllegalArgumentException.class);
    }
}

