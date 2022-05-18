package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private final List<Rank> gameResult = new ArrayList<>();

    public void calculateRank(WinningLotto winningLotto, Lotto userLotto) {
        int countOfMatch = winningLotto.countOfMatchNumber(userLotto);
        boolean matchBonus = winningLotto.containsBonusNumber(userLotto);

        gameResult.add(Rank.getRank(countOfMatch, matchBonus));
    }

    public Map<Rank, Integer> gameResult() {
        Map<Rank, Integer> mappedByRank = new LinkedHashMap<>();
        for (Rank value : Rank.values()) {
            mappedByRank.put(value, (int) gameResult.stream().filter(result -> result == value).count());
        }

        mappedByRank.remove(Rank.MISS);
        return Collections.unmodifiableMap(mappedByRank);
    }

    public double benefitResult(double deposit) {
        return gameResult.stream().mapToLong(Rank::getWinningMoney).sum() / deposit;
    }
}
