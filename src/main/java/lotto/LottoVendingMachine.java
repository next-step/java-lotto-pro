package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.TicketCheckResult;
import lotto.dto.LottoResult;
import lotto.dto.LottoResultItem;
import lotto.dto.LottoWin;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.ExceptionMessage.NOT_ENOUGH_AMOUNT;

public class LottoVendingMachine {

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoVendingMachine(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public LottoTicket sellTicket(Money money) {
        return sellTicket(money, new ArrayList<>());
    }

    public LottoTicket sellTicket(Money money, List<LottoGame> manualLottoGames) {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addAllGames(manualLottoGames);

        int autoNumberOfGames = lottoTicket.numberOfGames(money) - manualLottoGames.size();
        for (int i = 0; i < autoNumberOfGames; i++) {
            lottoTicket.addGame(new LottoGame(lottoNumbersGenerator.generate()));
        }

        return lottoTicket;
    }

    public LottoResult check(LottoTicket ticket, LottoWin lottoWin) {
        TicketCheckResult result = ticket.check(lottoWin.getWinningNumbers(), lottoWin.getBonusNumber());
        List<LottoResultItem> items = result.mapLottoResultItemList(lottoWin);

        return new LottoResult(
                calculateRateOfReturn(ticket.moneyValue(), items),
                items);
    }

    private String calculateRateOfReturn(int investment, List<LottoResultItem> items) {
        double totalProfit = items.stream()
                .mapToDouble(item -> item.getPrizeMoney() * item.getCount())
                .reduce(0, (acc, profit) -> acc + profit);

        return String.format("%.2f", totalProfit / investment);
    }

    public void validateMoneyAmount(Money money) {
        LottoTicket lottoTicket = new LottoTicket();
        if (lottoTicket.numberOfGames(money) < 1) {
            throw new IllegalArgumentException(NOT_ENOUGH_AMOUNT.getMessage());
        }
    }
}
