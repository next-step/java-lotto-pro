package lotto;

import lotto.domain.LottoTicket;
import lotto.dto.LottoResult;
import lotto.dto.LottoResultItem;
import lotto.dto.LottoWin;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {

    public static final int PRICE = 1000;
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int COUNT = 6;

    public LottoTicket sellTicket(Money money) {
        List<List<Integer>> lottoGamesNumbers = new ArrayList<>();
        final int numberOfGames = money.numberOfGames(PRICE);
        for (int i = 0; i < numberOfGames; i++) {
            lottoGamesNumbers.add(LottoNumbersGenerator.generate(MIN, MAX, COUNT));
        }

        LottoTicket lottoTicket = new LottoTicket(lottoGamesNumbers);
        return lottoTicket;
    }

    public LottoResult check(LottoTicket ticket, LottoWin lottoWin) {
        TicketCheckResult result = ticket.check(lottoWin.getWinningNumbers());
        List<LottoResultItem> items = result.mapLottoResultItemList(lottoWin);

        return new LottoResult(
                calculateRateOfReturn(ticket.size() * PRICE, items),
                items);
    }

    private String calculateRateOfReturn(int investment, List<LottoResultItem> items) {
         double totalProfit = items.stream()
                .mapToDouble(item -> item.getPrizeMoney() * item.getCount())
                .reduce(0, (acc, profit) -> acc + profit);

        return String.format("%.2f", totalProfit / investment);
    }
}
