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
        OutputView.printMessage(getLottoQuantity(money) + "개를 구매했습니다.");
        purchaseLotto();
        OutputView.printMyLotto(purchasedLottos);
        readLastWinningNumbers();
        OutputView.printLine();
        OutputView.showLottoStatistics(purchasedLottos, lastWinningNumbers);
        OutputView.showLottoProfit(purchasedLottos, lastWinningNumbers, money);
    }

    public void readMoney() {
        String input = InputView.readUserInput(REQUEST_MONEY);
        money = new Money(input);
    }

    public void purchaseLotto() {
        long lottoQuantity = getLottoQuantity(money);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottoList.add(generateLotto());
        }
        purchasedLottos = new PurchasedLottos(lottoList);
    }

    public void readLastWinningNumbers() {
        lastWinningNumbers = InputView.readUserInput(REQUEST_LAST_WINNING_NUMBERS);
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

    public PurchasedLottos getPurchasedLottos() {
        return purchasedLottos;
    }
}
