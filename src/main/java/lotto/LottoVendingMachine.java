package lotto;

import lotto.dto.LottoResult;
import lotto.dto.LottoWin;
import lotto.dto.LottoResultItem;

import java.util.*;
import java.util.stream.Collectors;

public class LottoVendingMachine {

    public static final int PRICE = 1000;
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int COUNT = 6;

    public LottoTicket sellTicket(int money) {
        List<List<Integer>> lottoGamesNumbers = new ArrayList<>();
        final int numberOfGames = money / PRICE;
        for (int i = 0; i < numberOfGames; i++) {
            lottoGamesNumbers.add(LottoNumbersGenerator.generate(MIN, MAX, COUNT));
        }

        LottoTicket lottoTicket = new LottoTicket(lottoGamesNumbers);
        return lottoTicket;
    }

    public LottoResult check(LottoTicket ticket, LottoWin lottoWin) {
        Map<Match, Integer> result = ticket.check(lottoWin.getWinningNumbers());
        List<LottoResultItem> items = result.entrySet().stream()
                .filter(m -> lottoWin.getPrizeMoneyByMatch().get(m.getKey()) != null)
                .map(e -> new LottoResultItem(
                        e.getKey(),
                        lottoWin.getPrizeMoneyByMatch().get(e.getKey()),
                        e.getValue()))
                .collect(Collectors.toList());

        int money = ticket.size() * PRICE;
        int profit = items.stream()
                .mapToInt(item -> item.getPrizeMoney() * item.getCount())
                .reduce(0, (acc, p) -> acc + p);
        return new LottoResult(
                String.format("%.2f", ((float) profit / money)),
                items);
    }
}
