package lotto;

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

    public Map<Integer, Integer> check(final List<LottoNumber> winningNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i <= LottoGame.SIZE; i++) {
            result.put(i, 0);
        }

        lottoGames.forEach(lottoGame -> {
            int match = lottoGame.check(winningNumbers);
            result.put(match, result.get(match) + 1);
        });

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        lottoGames.forEach(g -> builder.append(g.toString() + "\n"));
        return builder.toString();
    }
}
