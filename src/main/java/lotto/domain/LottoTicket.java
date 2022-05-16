package lotto.domain;

import lotto.LottoNumbersGenerator;
import lotto.Match;
import lotto.TicketCheckResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int PRICE = 1000;
    private final List<LottoGame> lottoGames;

    public LottoTicket(final int money) {
        validate(money);
        List<LottoGame> lottoGames = new ArrayList<>();
        for (int i = 0; i < money / PRICE; i++) {
            lottoGames.add(new LottoGame(LottoNumbersGenerator.generate(1, 45, 6)));
        }
        this.lottoGames = lottoGames;
    }

    public LottoTicket(List<List<Integer>> lottoGamesNumbers) {
        this.lottoGames = lottoGamesNumbers.stream()
                .map(gameNumbers -> new LottoGame(gameNumbers))
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoGames.size();
    }

    private void validate(final int money) {
        if (money / PRICE <= 0) {
            throw new IllegalArgumentException("잘못된 금액");
        }
    }

    public TicketCheckResult check(final List<LottoNumber> winningNumbers) {
        Map<Match, Integer> result = new HashMap<>();
        for (int i = 0; i <= LottoGame.SIZE; i++) {
            result.put(new Match(i), 0);
        }

        List<Match> matches = lottoGames.stream()
                .map(game -> game.check(winningNumbers))
                .collect(Collectors.toList());

        matches.forEach(match -> result.put(match, result.get(match) + 1));

        return new TicketCheckResult(result);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        lottoGames.forEach(g -> builder.append(g.toString() + "\n"));
        return builder.toString();
    }
}
