package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {

    private final CriteriaProvider criteriaProvider = () -> new HashMap<Integer, Long>() {
        {
            put(3, 5000L);
        }
    };

    @Test
    @DisplayName("당첨 결과 생성")
    public void testGenerateStatistics() {
        List<Lotto> emptyLottos = new ArrayList<>();
        Numbers winningNumbers = Numbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        Reward reward = Reward.generate(emptyLottos, winningNumbers, criteriaProvider);
        List<String> statistics = reward.generateStatistics();
        assertThat(statistics.size()).isEqualTo(criteriaProvider.get().size());
    }
}
