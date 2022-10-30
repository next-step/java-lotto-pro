package study.step3;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Winner> winnerList;

    public Winners() {
        this.winnerList = new ArrayList<>();
    }

    public void add(Winner winner) {
        winnerList.add(winner);
    }

    public int nThPrizeSize(int nTh) {
        return (int) winnerList.stream()
                .filter(winner -> winner.getCorrectNumber() == nTh).count();
    }

    public double earningRate(Money inputMoney) {
        return inputMoney.divide(totalReward());
    }

    private int totalReward() {
        int result = 0;
        for (Prize prize : Prize.values()) {
            result += nThPrizeSize(prize.getWinNumber()) * prize.getReward();
        }
        return result;
    }
}
