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

    public void play() {
        Money money = readMoney();
        OutputView.printMessage(getLottoQuantity(money) + "개를 구매했습니다.");
        purchaseLotto(money);
        OutputView.printMyLotto(purchasedLottos);
        readLastWinningNumbers();
        OutputView.printLine();
        OutputView.showLottoStatistics(purchasedLottos, lastWinningNumbers);
        OutputView.showLottoProfit(purchasedLottos, lastWinningNumbers, money);
    }

    public Money readMoney() {
        String input = InputView.readUserInput(REQUEST_MONEY);
        return new Money(input);
    }

    public void purchaseLotto(Money money) {
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
