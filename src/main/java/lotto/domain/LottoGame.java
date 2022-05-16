package lotto.domain;

import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    private final LottoTickets lottoTickets;
    private final Money money;

    public LottoGame(LottoTickets lottoTickets, Money money) {
        this.lottoTickets = lottoTickets;
        this.money = money;
    }

    public void play() {
        System.out.println("print");
        ResultView.printCount(money.calculateLottoTicketCount());
        ResultView.printLottoTickets(lottoTickets);

        List<Integer> lottoNumbers = LottoNumbers.getLottoNumbersFromInput();

        List<LottoPrize> matchResults = lottoTickets.matchResults(
                new LottoTicket(LottoNumbers.generateLottoNumbers(lottoNumbers).getReadOnlyLottoNumbers())
        );
        ResultView.printStatistics(matchResults, money);
    }
}
