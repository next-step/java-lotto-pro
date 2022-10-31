package step3.controller;

import java.util.List;
import step3.model.lotto.Lotto;
import step3.model.lotto.LottoList;
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
        LottoList lottoList = createAutoLottoListByOrder(order);
        Lotto winningLotto = getWinningLotto();
        Results results = getLottoResults(lottoList, winningLotto);
        evaluateStatisticResult(order, results);
    }

    private LottoList createAutoLottoListByOrder(Order order) {
        List<Lotto> lottos = lottoMachine.issueAutoLottoList(order);
        LottoList lottoList = new LottoList(lottos);
        OutputView.printTickets(lottoList);
        return lottoList;
    }

    private Order makeOrder() {
        Money money = getMoneyInput();
        int ticketCount = money.availableTicketCount(Rule.TICKET_PRICE);
        Order order =  new Order(ticketCount);
        OutputView.printOrder(order);
        return order;
    }

    private void evaluateStatisticResult(Order order, Results results) {
        long totalPrice = order.getTotalPrice(Rule.TICKET_PRICE);
        long totalPrize = results.getWinningPrize();
        Statistics statistics = new Statistics(totalPrice, totalPrize);
        double statisticResult = statistics.getStatisticResult();
        OutputView.printStatisticResult(statisticResult);
    }

    private Results getLottoResults(LottoList lottoList, Lotto lotto) {
        List<Integer> lottoResults = lottoList.getResults(lotto);
        Results results = new Results();
        results.recordResult(lottoResults);
        OutputView.printResults(results);
        return results;
    }


    private Lotto getWinningLotto() {
        String lottoInput = InputView.requestInputLotto();
        System.out.println(lottoInput);
        List<Integer> lotto =  lottoMachine.createWinningLotto(lottoInput);
        return new Lotto(lotto);
    }

    private Money getMoneyInput() {
        String moneyInput = InputView.requestInputMoney();
        return new Money(moneyInput);
    }


}
