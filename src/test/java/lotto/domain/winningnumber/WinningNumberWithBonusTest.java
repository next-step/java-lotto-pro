package lotto.domain.winningnumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberWithBonusTest {

    List<Integer> winningNumbers = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
        winningNumbers.add(7); // 보너스볼
    }

    @Test
    @DisplayName("로또 번호와 당첨번호가 매칭 된 수만큼 카운트")
    void matchNumber() {
        assertThat(new WinningNumberWithBonus(winningNumbers)
                .matchNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7).iterator())).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스볼 포함이면 true 아니면 false")
    void isMatchBonus() {
        assertThat(new WinningNumberWithBonus(winningNumbers)
                .isMatchBonus(Arrays.asList(1, 2, 3, 4, 5, 6, 7).iterator())).isTrue();
        assertThat(new WinningNumberWithBonus(winningNumbers)
                .isMatchBonus(Arrays.asList(1, 2, 3, 4, 5, 6, 8).iterator())).isFalse();
    }
}
