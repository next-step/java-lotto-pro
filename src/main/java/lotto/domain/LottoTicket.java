package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoTicket {

    private final List<LottoGame> lottoGames;

    public LottoTicket() {
        this.lottoGames = new ArrayList<>();
    }

    public void addGame(LottoGame lottoGame) {
        lottoGames.add(lottoGame);
    }

    public void addAllGames(List<LottoGame> lottoGames) {
        lottoGames.forEach(game -> this.lottoGames.add(game));
    }

    public int size() {
        return lottoGames.size();
    }

    public int moneyValue(int pricePerGame) {
        return lottoGames.size() * pricePerGame;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoGames, that.lottoGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGames);
    }
}
