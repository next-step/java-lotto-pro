package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto> userLotto = new ArrayList<>();
    private Lotto winnersLotto;
    private Coin coin;
    private final GameResult gameResult = new GameResult();
    private static final double BENEFIT_REFERENCE_VALUE = 1;

    public LottoGame() {

    }

    public boolean insertMoney(String money) {
        try {
            coin = new Coin(money);
            Price.minimumPriceCheck(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public int buyLottoTicket(NumberGenerator numberGenerator) {
        int countOfLotto = coin.buyLottoTicket(Price.lottoPrice());
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

    public Map<Rank, Long> gameResult() {
        for (Lotto lotto : userLotto) {
            gameResult.calculateRank(winnersLotto, lotto);
        }
        return gameResult.gameResult();
    }

    public double benefitResult() {
        return gameResult.benefitResult(coin.getDeposit());
    }

    public double referenceValue() {
        return BENEFIT_REFERENCE_VALUE;
    }

    public List<Lotto> getUserLottery() {
        return userLotto;
    }
}
