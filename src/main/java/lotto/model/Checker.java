package lotto.model;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

import static lotto.common.Constants.GET_NUMBER_COUNT;

public class Checker {

    private LinkedHashMap<Integer, Integer> results;

    public Checker(Games games, WinningNumbers winningNumbers) {
        init();

        for (Game game : games.getList()) {
            int matchedCount = matchCount(game, winningNumbers);
            results.put(matchedCount, results.get(matchedCount) + 1);
        }
    }

    private void init() {
        results = new LinkedHashMap<>();

        for (int i = 0; i <= GET_NUMBER_COUNT; i++) {
            results.put(i, 0);
        }
    }

    private int matchCount(Game game, WinningNumbers winningNumbers) {
        return (int) game.getNumbers().stream()
            .filter(number -> winningNumbers.getValues().stream().anyMatch(Predicate.isEqual(number)))
            .count();
    }

    public LinkedHashMap<Integer, Integer> getResults() {
        return results;
    }

}
