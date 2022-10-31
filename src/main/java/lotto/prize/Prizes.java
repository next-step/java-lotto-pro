package lotto.prize;

import lotto.status.ErrorStatus;

import java.math.BigDecimal;
import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        validate(prizes);
        this.prizes = prizes;
    }

    private void validate(List<Prize> prizes) {
        if (prizes == null) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_PRIZES.getMessage());
        }
    }

    public int countMatchPrize(Prize prize) {
        return (int) prizes.stream()
                .filter(v -> v == prize)
                .count();
    }

    public BigDecimal sumReward() {
        BigDecimal reward = BigDecimal.ZERO;
        for (Prize prize : prizes) {
            BigDecimal prizeMoney = prize.getPrizeMoney();
            reward = reward.add(prizeMoney);
        }
        return reward;
    }
}
