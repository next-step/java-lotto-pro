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
    private MyLotto myLotto = new MyLotto();
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

    public void readMoney() {
        String input = InputView.readUserInput(REQUEST_MONEY);
        money = new Money(input);
    }

    public void purchaseLotto() {
        long lottoQuantity = getLottoQuantity(money);
        OutputView.printMessage((money.getMoney()/LOTTO_PRICE) + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottoList.add(generateLotto());
        }
        myLotto = new MyLotto(lottoList);
    }

    public void printMyLotto() {
        List<Lotto> lottoList = myLotto.getLottoList();
        for (Lotto lotto : lottoList) {
            OutputView.printMessage(lotto.toString());
        }
        OutputView.printLine();
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
}
