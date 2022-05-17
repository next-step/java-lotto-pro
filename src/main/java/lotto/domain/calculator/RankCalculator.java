package lotto.domain.calculator;

import java.util.Arrays;
import lotto.domain.Rank;

public interface RankCalculator {
    Rank calculator(int countOfMatch);

    default Rank getRankByCountOfMatch(int countOfMatch) {
        return Arrays.stream(Rank.values()).filter(x -> x.getCountOfMatch() == countOfMatch).findFirst()
            .orElse(Rank.MISS);
    }
}
