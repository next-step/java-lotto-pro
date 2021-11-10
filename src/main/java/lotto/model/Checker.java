package lotto.model;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

public class Checker {

    private LinkedHashMap<Rank, Integer> results;

    public Checker(Games games, LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        init();

        for (Game game : games.getList()) {
            int matchedCount = matchCount(game, winningNumbers);
            boolean matchBonus = isMatchedBonusNumber(game, bonusNumber);
            Rank rank = Rank.valueOf(matchedCount, matchBonus);
            results.put(rank, results.get(rank) + 1);
        }
    }

    private void init() {
        results = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    private int matchCount(Game game, LottoNumbers winningNumbers) {
        return (int) game.getNumbers().stream()
                .filter(number -> winningNumbers.getValues()
                        .stream()
                        .map(winningNumber -> winningNumber.getValue())
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean isMatchedBonusNumber(Game game, LottoNumber bonusNumber) {
        return game.getNumbers()
                .stream()
                .anyMatch(number -> number == bonusNumber.getValue());
    }

    public LinkedHashMap<Rank, Integer> getResults() {
        return results;
    }

}
