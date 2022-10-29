package lotto.controller;

import lotto.constant.numbers.LottoConstant;
import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.model.lotto.ticket.LottoNumberGenerator;
import lotto.model.lotto.ticket.LottoTicket;
import lotto.model.lotto.ticket.LottoTicketsBucket;
import lotto.model.money.to.buy.MoneyToBuy;
import lotto.model.winning.numbers.WinningNumbers;
import lotto.view.*;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
        // * 사용자가 구입 금액을 입력한다.
        // * 입력받은 구입 금액을 저장한다.
        // * 거스름돈은 제거한다.
        DemandMoneyToBuyInputPrinter.print();
        final MoneyToBuy moneyToBuy = new MoneyToBuyAcceptor().accept();

        // * 로또 몇 개를 구매했는지 출력한다.
        NumberOfLottoTicketsPrinters.print(moneyToBuy);

        // * 로또를 구매할 수 있는 만큼 구매한다.
        // * 로또 한 장에는 6 개의 무작위 숫자가 있다.
        // * 로또 한 장을 생성할 때마다 그 로또 용지를 출력해서 사용자에게 보여준다.
        int numberOfAffordableLotto = moneyToBuy.numberOfAffordableLottoTickets();
        final LottoTicketsBucket lottoTicketsBucket = new LottoTicketsBucket(numberOfAffordableLotto);
        while (0 < numberOfAffordableLotto--) {
            final List<Integer> candidates = intsFromOneToFortyFive();
            final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
            final LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);
            LottoTicketPrinter.print(lottoTicket);
            lottoTicketsBucket.addLottoTicket(lottoTicket);
        }
        BlankLinePrinter.print();

        // * 사용자가 당첨 번호 6 개를 입력한다.
        DemandWinningNumbersInputPrinter.print();
        final WinningNumbers winningNumbers = new WinningNumbersAcceptor().accept();
        BlankLinePrinter.print();

        // * 로또 각 장과 당첨 번호를 비교해서 3 개 일치, 4 개 일치, 5 개 일치, 6 개 일치하는 개수를 저장한다.
        // * 번호 일치 개수를 확인하면서 최종 당첨금 총 합을 구한다.
        LottoScoreTitlePrinter.print();
        lottoTicketsBucket.sameNumberCountOfAllLottoTickets(winningNumbers);
        LottoWinningStatisticsPrinter.print(lottoTicketsBucket);

        // * [사용자의 초기 구입 금액에서 거스름돈을 뺀 금액] 을 [최종 당첨금 총 합] 으로 나누어서 총 수익률을 구한다.
        final String profitRatioString = moneyToBuy.profitRatio(lottoTicketsBucket);
        ProfitRatioPrinter.print(profitRatioString);
    }

    private List<Integer> intsFromOneToFortyFive() {
        final List<Integer> fullCandidateList = new ArrayList<>(LottoConstant.LOTTO_MAXIMUM_NUMBER);
        for (int i = LottoConstant.LOTTO_MINIMUM_NUMBER; i <= LottoConstant.LOTTO_MAXIMUM_NUMBER; ++i) {
            fullCandidateList.add(i);
        }
        return fullCandidateList;
    }
}
