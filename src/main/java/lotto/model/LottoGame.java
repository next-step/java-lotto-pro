package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto> userLotto = new ArrayList<>();
    private Lotto winnersLotto;
    private WinningLotto winningLotto;
    private Coin coin;
    private LottoCount lottoCount;
    private final GameResult gameResult = new GameResult();
    private static final double BENEFIT_REFERENCE_VALUE = 1;

    public LottoGame() {

    }

    public boolean insertMoney(String money) {
        try {
            coin = new Coin(money);
            lottoCount = new LottoCount(coin.maxCountOfLotto());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean purchaseManualLotto(String countOfManualLotto) {
        try {
            lottoCount.purchaseManualLottoTicket(countOfManualLotto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void inputManualLottoNumber(String inputs) {
        try {
            userLotto.add(new Lotto(new InputNumberGenerator(inputs)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int purchaseAutoLotto(NumberGenerator numberGenerator) {
        final int countOfLotto = lottoCount.purchaseAutoLottoTicket();
        for (int index = 0; index < countOfLotto; index++) {
            userLotto.add(new Lotto(numberGenerator));
        }
        return countOfLotto;
    }

    public boolean winnersNumber(String numbers) {
        try {
            winnersLotto = new Lotto(new InputNumberGenerator(numbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean bonusNumber(String number) {
        try {
            final Number bonusNumber = new Number(number);
            winningLotto = new WinningLotto(winnersLotto, bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Map<Rank, Integer> gameResult() {
        for (Lotto lotto : userLotto) {
            gameResult.calculateRank(winningLotto, lotto);
        }
        return gameResult.gameResult();
    }

    public double benefitResult() {
        return gameResult.benefitResult(coin.getDeposit());
    }

    public double referenceValue() {
        return BENEFIT_REFERENCE_VALUE;
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }
}
