package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTypeTest {

    @Test
    @DisplayName("Lotto, 기준 Lotto 와 match 되는 숫자에 따른 Reward Type 반환")
    public void RewardType_match_Type() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 45));
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 20, 30, 40, 34, 45));
        Lotto lotto = new Lotto(numbers);
        Lotto winLotto = new Lotto(winNumbers);
        assertThat(RewardType.match(lotto, winLotto)).isEqualTo(RewardType.THIRD);
    }
}
