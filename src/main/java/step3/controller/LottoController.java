package step3.controller;

import java.util.ArrayList;
import java.util.List;
import step3.model.lotto.LottoList;
import step3.model.lotto.WinningLotto;
import step3.model.machine.Money;
import step3.model.machine.Order;
import step3.model.machine.Results;
import step3.model.machine.Statistics;
import step3.model.machine.LottoAutoGenerator;
import step3.model.machine.LottoMachine;
import step3.model.value.Rule;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController(LottoAutoGenerator ticketGenerator) {
        this.lottoMachine = new LottoMachine(ticketGenerator);
    }

    public void start() {
        Order order = makeOrder();
        LottoList lottoList = createLottoListByOrder(order);

        WinningLotto winningLotto = getWinningLotto();
        Results results = getLottoResults(lottoList, winningLotto);
        evaluateStatisticResult(order, results);
    }

    private LottoList createLottoListByOrder(Order order) {
        int manualTicketCount = order.getManualTicketCount();
        List<String> manualInputs = InputView.requestInputBonusLotto(manualTicketCount);
        LottoList lottoList = lottoMachine.issueLottoList(order, manualInputs);
        OutputView.printOrder(order);
        OutputView.printTickets(lottoList);
        return lottoList;
    }

    private Order makeOrder() {
        Money money = getMoneyInput();
        int ticketCount = money.availableTicketCount(Rule.TICKET_PRICE);
        int manualTicketCount = InputView.requestManualTicketCount();
        Order order =  new Order(ticketCount, manualTicketCount);
        return order;
    }

    private void evaluateStatisticResult(Order order, Results results) {
        long totalPrice = order.getTotalPrice(Rule.TICKET_PRICE);
        long totalPrize = results.getWinningPrize();
        Statistics statistics = new Statistics(totalPrice, totalPrize);
        double statisticResult = statistics.getStatisticResult();
        OutputView.printStatisticResult(statisticResult);
    }

    private Results getLottoResults(LottoList lottoList, WinningLotto winningLotto) {
        Results results = lottoList.getMatchResults(winningLotto);
        OutputView.printResults(results);
        return results;
    }


    private WinningLotto getWinningLotto() {
        String lottoInput = InputView.requestInputLotto();
        int bonusInput = InputView.requestInputBonus();
        return lottoMachine.createWinningLotto(lottoInput, bonusInput);
    }

    private Money getMoneyInput() {
        String moneyInput = InputView.requestInputMoney();
        return new Money(moneyInput);
    }


}
