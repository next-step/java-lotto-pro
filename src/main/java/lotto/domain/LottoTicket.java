package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {

    private static final int PRICE_PER_GAME = 1000;
    private final List<LottoGame> lottoGames;

    public LottoTicket() {
        this.lottoGames = new ArrayList<>();
    }

    public int numberOfGames(Money money) {
        return money.numberOfGames(PRICE_PER_GAME);
    }

    public void addGame(LottoGame lottoGame) {
        lottoGames.add(lottoGame);
    }

    public int size() {
        return lottoGames.size();
    }

    public int moneyValue() {
        return lottoGames.size() * PRICE_PER_GAME;
    }

    public TicketCheckResult check(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank value : Rank.values()) {
            result.put(value, 0);
        }

        lottoGames.stream()
                .map(game -> game.check(winningNumbers, bonusNumber))
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
