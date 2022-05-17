package step3.lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:52 오후
 */
public class MatchStatistic {

    public static final int SINGLE_GAME_PRICE = 1000;
    public static final int RATE_FORMAT_MULTIPLICATION = 100;
    public static final Double RATE_FORMAT_DIVISOR = 100.0;

    private List<MatchResult> matchResult;
    private int firstPlaceCount;
    private int secondPlaceCount;
    private int thirdPlaceCount;
    private int forthPlaceCount;
    private long totalReward;

    public MatchStatistic() {
        this.matchResult = new ArrayList<>();
    }

    public int getFirstPlaceCount() {
        return firstPlaceCount;
    }

    public int getSecondPlaceCount() {
        return secondPlaceCount;
    }

    public int getThirdPlaceCount() {
        return thirdPlaceCount;
    }

    public int getForthPlaceCount() {
        return forthPlaceCount;
    }

    public void add(MatchResult matchResult) {
        addPlaceCount(matchResult);
        this.totalReward += matchResult.getRewardPrice();
        this.matchResult.add(matchResult);
    }

    public double getRateOfProfit() {
        return formattingRate(totalReward / intToDouble(tryPrice()));
    }

    private void addPlaceCount(MatchResult matchResult) {
        if (matchResult.isFirstPlace()) {
            this.firstPlaceCount++;
        }
        if (matchResult.isSecondPlace()) {
            this.secondPlaceCount++;
        }
        if (matchResult.isThirdPlace()) {
            this.thirdPlaceCount++;
        }
        if (matchResult.isForthPlace()) {
            this.forthPlaceCount++;
        }
    }

    private int tryPrice() {
        return matchResult.size() * SINGLE_GAME_PRICE;
    }

    private double intToDouble(int input) {
        return input;
    }

    private double formattingRate(double rate) {
        return Math.floor(rate * RATE_FORMAT_MULTIPLICATION) / RATE_FORMAT_DIVISOR;
    }
}
