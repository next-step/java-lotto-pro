package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private final List<Rank> gameResult = new ArrayList<>();

    public void calculateRank(Lottery winnersLottery, Lottery userLottery) {
        long matchCount = winnersLottery.getNumbers().stream()
                .filter(lottoNumber -> userLottery.getNumbers().contains(lottoNumber))
                .count();

        gameResult.add(Rank.getRank(matchCount));
    }

    public Map<Rank, Long> gameResult() {
        Map<Rank, Long> mappedByRank = new LinkedHashMap<>();
        for (Rank value : Rank.values()) {
            mappedByRank.put(value, gameResult.stream().filter(result -> result == value).count());
        }

        mappedByRank.remove(Rank.NONE);
        return Collections.unmodifiableMap(mappedByRank);
    }

    public double benefitResult(double deposit) {
        return gameResult.stream().mapToLong(Rank::getPrice).sum() / deposit;
    }
}
