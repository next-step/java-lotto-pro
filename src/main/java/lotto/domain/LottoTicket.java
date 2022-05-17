package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int PRICE = 1000;
    private final List<LottoGame> lottoGames;

    public LottoTicket(List<List<Integer>> lottoGamesNumbers) {
        this.lottoGames = lottoGamesNumbers.stream()
                .map(gameNumbers -> new LottoGame(gameNumbers))
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoGames.size();
    }

    public int moneyValue() {
        return lottoGames.size() * PRICE;
    }

    public TicketCheckResult check(final WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank value : Rank.values()) {
            result.put(value, 0);
        }

        lottoGames.stream()
                .map(game -> game.check(winningNumbers))
                .forEach(rank -> result.put(rank, result.get(rank) + 1));

        return new TicketCheckResult(result);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        lottoGames.forEach(g -> builder.append(g.toString() + "\n"));
        return builder.toString();
    }
}
