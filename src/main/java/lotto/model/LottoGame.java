package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> userLotto = new ArrayList<>();
    private Coin coin;
    private LottoCount lottoCount;

    public LottoGame() {

    }

    public void insertMoney(String money) {
        coin = new Coin(money);
        lottoCount = new LottoCount(coin.maxCountOfLotto());
    }

    public int purchaseManualLotto(String countOfManualLotto) {
        return lottoCount.purchaseManualLottoTicket(countOfManualLotto);
    }

    public void inputManualLottoNumber(String inputs) {
        userLotto.add(new Lotto(new InputNumberGenerator(inputs)));
    }

    public int purchaseAutoLotto(NumberGenerator numberGenerator) {
        final int countOfLotto = lottoCount.purchaseAutoLottoTicket();
        for (int index = 0; index < countOfLotto; index++) {
            userLotto.add(new Lotto(numberGenerator));
        }
        return countOfLotto;
    }

    public double getDeposit() {
        return coin.getDeposit();
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    public boolean isSameSizeOfUserLotto(int number) {
        return userLotto.size() == number;
    }
}
