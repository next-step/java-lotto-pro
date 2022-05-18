package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static lotto.domain.LottoConstant.LOTTO_PRICE;

public class LottoMachine {
    private long money;

    public LottoMachine(String input) {
        try {
            money = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 액수입니다.");
        }

        if (isInvalidMoney(money)) {
            throw new IllegalArgumentException("유효하지 않은 액수입니다.");
        }
    }

    public LottoMachine(long input) {
        this(String.valueOf(input));
    }

    public static BigDecimal calculateWinningMoney(LottoResult lottoResult) {
        List<Ranking> rankingList = lottoResult.getRankingList();
        return rankingList.stream()
                .mapToInt(Ranking::getReward)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateWinningProfit(LottoResult lottoResult) {
        BigDecimal winningMoney = calculateWinningMoney(lottoResult);
        BigDecimal divisor = new BigDecimal(money);
        return winningMoney.divide(divisor).setScale(2, RoundingMode.HALF_UP);
    }

    private boolean isInvalidMoney(long money) {
        return money < LOTTO_PRICE;
    }

    public long getMoney() {
        return money;
    }

    public long calculatePurchaseLottos() {
        return money / LOTTO_PRICE;
    }
}
