package lotto.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Winning {
    private static final String WINNING_NUMBERS_BONUS_NUMBER_CANNOT_BE_DUPLICATED = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    private final Lottery lottery;
    private final Number bonusNumber;

    public Winning(Lottery lottery, Number bonusNumber) {
        if (lottery.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_BONUS_NUMBER_CANNOT_BE_DUPLICATED);
        }
        this.lottery = lottery;
        this.bonusNumber = bonusNumber;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }

    public Summary createSummary(Lotteries purchase) {
        Map<Rank, Integer> ranks = createRanks();

        purchase.getLotteries()
                .forEach(target -> {
                    AtomicInteger count = new AtomicInteger();
                    AtomicBoolean bonus = new AtomicBoolean(false);

                    target.getNumbers()
                          .forEach(number -> {
                              if (lottery.contains(number)) {
                                  count.getAndIncrement();
                              }
                              if (bonusNumber.equals(number)) {
                                  bonus.set(true);
                              }
                          });

                    ranks.put(Rank.valueOf(count.get(), bonus.get())
                            , ranks.get(Rank.valueOf(count.get(), bonus.get())) + 1);
                });

        ranks.remove(Rank.MISS);
        return new Summary(ranks);
    }

    private Map<Rank, Integer> createRanks() {
        Map<Rank, Integer> ranks = new LinkedHashMap<>();
        Arrays.stream(Rank.reverseValues())
              .forEach(rank -> ranks.put(rank, 0));
        return ranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winning winning = (Winning) o;
        return Objects.equals(lottery, winning.lottery) && Objects.equals(bonusNumber, winning.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottery, bonusNumber);
    }

    @Override
    public String toString() {
        return "Winning{" +
                "lottery=" + lottery +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
