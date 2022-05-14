package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.*;
import static lotto.view.InputView.REQUEST_LAST_WINNING_NUMBERS;
import static lotto.view.InputView.REQUEST_MONEY;

public class LottoGame {
    private static final List<LottoNo> lottoNumbers = new ArrayList<>();
    private Money money = new Money(0);
    private PurchasedLottos purchasedLottos = new PurchasedLottos();
    private LottoResult result = new LottoResult();
    private String lastWinningNumbers = "";

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumbers.add(new LottoNo(number));
        }
    }

    public LottoGame() {
    }

    public LottoGame(long money) {
        this.money = new Money(money);
    }

    public LottoGame(String money) {
        this(Long.parseLong(money));
    }

    public LottoGame(PurchasedLottos purchasedLottos, String lastWinningNumbers) {
        this.purchasedLottos = purchasedLottos;
        this.lastWinningNumbers = lastWinningNumbers;
    }

    public LottoGame(Money money, PurchasedLottos purchasedLottos, String lastWinningNumbers) {
        this.money = money;
        this.purchasedLottos = purchasedLottos;
        this.lastWinningNumbers = lastWinningNumbers;
    }

    public void play() {
        readMoney();
        purchaseLotto();
        printMyLotto();
        readLastWinningNumbers();
        showLottoStatistics();
        showLottoProfit();
    }

    public void readMoney() {
        String input = InputView.readUserInput(REQUEST_MONEY);
        money = new Money(input);
    }

    public void purchaseLotto() {
        long lottoQuantity = getLottoQuantity(money);
        OutputView.printMessage(lottoQuantity + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottoList.add(generateLotto());
        }
        purchasedLottos = new PurchasedLottos(lottoList);
    }

    public void printMyLotto() {
        List<Lotto> lottoList = purchasedLottos.getLottoList();
        for (Lotto lotto : lottoList) {
            OutputView.printMessage(lotto.toString());
        }
        OutputView.printLine();
    }

    public void readLastWinningNumbers() {
        lastWinningNumbers = InputView.readUserInput(REQUEST_LAST_WINNING_NUMBERS);
        OutputView.printLine();
    }

    public void showLottoStatistics() {
        List<Ranking> rankings = purchasedLottos.compareLottos(new Lotto(lastWinningNumbers));
        result = new LottoResult(rankings);
        OutputView.printMessage("당첨 통계");
        OutputView.printMessage("---------");
        for (int matching = 3; matching <= LOTTO_SIZE; matching++) {
            Ranking rank = Ranking.findRank(matching);
            OutputView.printMessage("%d개 일치 (%d원)- %d개\r\n", matching, rank.getReward(), result.findRankings(matching).size());
        }
    }

    public void showLottoProfit() {
        double profit = (double)result.calculateWinningMoney() / money.getMoney();
        OutputView.printMessage("총 수익률은 %.2f입니다.", profit);
    }

    private Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNo> lottoNoList = lottoNumbers.stream()
                .limit(LottoConstant.LOTTO_SIZE)
                .collect(Collectors.toList());
        return new Lotto(lottoNoList);
    }

    private static long getLottoQuantity(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}
