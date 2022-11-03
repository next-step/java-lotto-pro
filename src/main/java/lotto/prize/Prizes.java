package lotto.prize;

import lotto.domain.seller.LottoSeller;
import lotto.status.ErrorStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prizes {
    private static final int DECIMAL_POINT_POSITION = 2;
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        validate(prizes);
        this.prizes = Collections.unmodifiableList(new ArrayList<>(prizes));
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

    public BigDecimal calculateYield(int lottoQuantity) {
        BigDecimal rewardSum = sumReward();
        return rewardSum.divide(BigDecimal.valueOf(lottoQuantity * LottoSeller.LOTTO_PRICE), DECIMAL_POINT_POSITION, BigDecimal.ROUND_FLOOR);
    }

    public BigDecimal sumReward() {
        return this.prizes.stream()
                .map(Prize::getPrizeMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
