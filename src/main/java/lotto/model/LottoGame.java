package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lottery> userLottery = new ArrayList<>();
    private Lottery winnersLottery;
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
            userLottery.add(new Lottery(numberGenerator));
        }
        return countOfLotto;
    }

    public boolean winnersNumber(String numbers) {
        try {
            winnersLottery = new Lottery(new InputNumberGenerator(numbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Map<Rank, Long> gameResult() {
        for (Lottery lottery : userLottery) {
            gameResult.calculateRank(winnersLottery, lottery);
        }
        return gameResult.gameResult();
    }

    public double benefitResult() {
        return gameResult.benefitResult(coin.getDeposit());
    }

    public double referenceValue() {
        return BENEFIT_REFERENCE_VALUE;
    }

    public List<Lottery> getUserLottery() {
        return userLottery;
    }
}
