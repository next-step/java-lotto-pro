package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.*;
import static lotto.view.InputView.REQUEST_MONEY;

public class LottoGame {
    private static final List<LottoNo> lottoNumbers = new ArrayList<>();
    private Money money;

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

    public static Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNo> lottoNoList = lottoNumbers.stream()
                .limit(LottoConstant.LOTTO_SIZE)
                .collect(Collectors.toList());
        return new Lotto(lottoNoList);
    }

    public static MyLotto purchaseLotto(int totalPrice) {
        int lottoQuantity = getLottoQuantity(totalPrice);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottoList.add(generateLotto());
        }
        return new MyLotto(lottoList);
    }

    private static int getLottoQuantity(int totalPrice) {
        return totalPrice / LOTTO_PRICE;
    }
}
