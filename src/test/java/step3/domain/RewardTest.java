package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {

    static Numbers winningNumbers;
    static Numbers losingNumbers;
    static Lotto selectLotto;

    @BeforeAll
    static void beforeAll() {
        winningNumbers = Numbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        losingNumbers = Numbers.generate(Arrays.asList(7, 8, 9, 10, 11, 12));
        selectLotto = Lotto.generate(winningNumbers);
    }

    @Test
    @DisplayName("로또 당첨")
    public void testGenerate() {
        Reward reward = Reward.generate(selectLotto, winningNumbers);
        assertThat(reward).isNotNull();
    }

    @Test
    @DisplayName("로또 미당첨, Reward 인스턴스 생성 실패")
    public void testGenerateError() {
        assertThatThrownBy(() -> {
            Reward.generate(selectLotto, losingNumbers);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Non-winning numbers.");
    }
}
