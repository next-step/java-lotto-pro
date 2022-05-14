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

    public Map<Long, Integer> check(final List<LottoNumber> winningNumbers) {
        Map<Long, Integer> result = new HashMap<>();
        lottoGames.forEach(lottoGame -> {
            Long match = lottoGame.check(winningNumbers);
            result.put(match, result.getOrDefault(match, 0) + 1);
        });

        return result;
    }
}
