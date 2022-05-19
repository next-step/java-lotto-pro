package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final Money money;

    public LottoGame(Money money) {
        this.money = money;
    }

    public void play() {
        LottoCount manualLottoCount = InputView.inputManualLottoPurchaseCount(money.calculateLottoTicketCount());
        LottoTickets lottoTickets = purchaseLottoTicket(money, manualLottoCount);

        ResultView.printCount(money.calculateLottoTicketCount(), manualLottoCount);
        ResultView.printLottoTickets(lottoTickets);

        LottoTicket lastWinningLottoTicket = inputLastWinningLottoNumbers();
        LottoNumber receivedBonusLottoNumber = InputView.inputBonusLottoNumber(
                LottoNumbers.from(lastWinningLottoTicket.getLottoNumbers()));

        LottoPrizes matchResults = lottoTickets.matchResults(
                lastWinningLottoTicket,
                receivedBonusLottoNumber
        );
        ResultView.printStatistics(matchResults, money);
    }

    private LottoTickets purchaseLottoTicket(Money money, LottoCount manualLottoCount) {
        LottoTickets manualPurchasedLottoTickets = inputManualLottoNumbers(manualLottoCount);
        LottoTickets autoPurchasedLottoTickets = new LottoTickets(money.calculateLottoTicketCount().minus(manualLottoCount));
        manualPurchasedLottoTickets.merge(autoPurchasedLottoTickets);

        return manualPurchasedLottoTickets;
    }

    private LottoTickets inputManualLottoNumbers(LottoCount manualLottoCount) {
        List<String> receivedLottoNumberStrings = InputView.inputManualLottoNumbers(manualLottoCount.getCount());
        List<LottoTicket> lottoTicketList = receivedLottoNumberStrings.stream()
                .map(receivedLottoNumberString -> LottoNumbers.getLottoNumbersFromInput(receivedLottoNumberString))
                .map(numberList -> LottoNumbers.generateLottoNumbers(numberList))
                .map(manualLottoNumbers -> new LottoTicket(manualLottoNumbers.getReadOnlyLottoNumbers()))
                .collect(Collectors.toList());

        return new LottoTickets(lottoTicketList);
    }

    private LottoTicket inputLastWinningLottoNumbers() {
        String receivedNumbers = InputView.inputLatestLottoResult();
        List<Integer> numberList = LottoNumbers.getLottoNumbersFromInput(receivedNumbers);
        LottoNumbers lastWinningLottoNumbers = LottoNumbers.generateLottoNumbers(numberList);

        return new LottoTicket(lastWinningLottoNumbers.getReadOnlyLottoNumbers());
    }
}
