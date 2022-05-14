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

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumbers.add(new LottoNo(number));
        }
    }

    public LottoGame() {
    }

    public void play() {
        Money money = readMoney();
        OutputView.printMessage(money.getAvailableLottosForPurchase() + "개를 구매했습니다.");

        PurchasedLottos purchasedLottos = purchaseLotto(money);
        OutputView.printMyLotto(purchasedLottos);

        String lastWinningNumbers = readLastWinningNumbers();
        OutputView.printLine();

        LottoResult result = matchLottoNumbers(purchasedLottos, lastWinningNumbers);
        OutputView.showLottoResult(result, money);
    }

    public PurchasedLottos purchaseLotto(Money money) {
        long lottoQuantity = money.getAvailableLottosForPurchase();
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottoList.add(generateLotto());
        }
        return new PurchasedLottos(lottoList);
    }

    private Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNo> lottoNoList = lottoNumbers.stream()
                .limit(LottoConstant.LOTTO_SIZE)
                .collect(Collectors.toList());
        return new Lotto(lottoNoList);
    }

    public LottoResult matchLottoNumbers(PurchasedLottos lottos, String lastWinningNumbers) {
        List<Ranking> rankings = lottos.compareLottos(new Lotto(lastWinningNumbers));
        return new LottoResult(rankings);
    }

    private Money readMoney() {
        String input = InputView.readUserInput(REQUEST_MONEY);
        return new Money(input);
    }

    private String readLastWinningNumbers() {
        return InputView.readUserInput(REQUEST_LAST_WINNING_NUMBERS);
    }
}
