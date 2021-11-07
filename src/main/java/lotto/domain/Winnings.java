package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static lotto.domain.Winnings.LottoRanking.*;

public enum Winnings {
    FIRST(FIRST_PLACE,2_000_000_000),
    SECOND(SECOND_PLACE, 30_000_000),
    THIRD(THIRD_PLACE,1_500_000),
    FORTH(FORTH_PLACE,50_000),
    FIFTH(FIFTH_PLACE,5_000),
    MISS(MISS_PLACE,0);

    private final LottoRanking lottoRanking;
    private final long amount;

    Winnings(LottoRanking lottoRanking, final long amount) {
        this.lottoRanking = lottoRanking;
        this.amount = amount;
    }

    private LottoRanking getLottoRanking() {
        return this.lottoRanking;
    }

    public int getCorrespondCount() {
        return this.lottoRanking.getCorrespondCount();
    }

    public int getBonusCorrespondCount() {
        return this.lottoRanking.getBonusCorrespondCount();
    }

    public long getAmount() {
        return this.amount;
    }

    private static final Map<LottoRanking, Winnings> rankToEnum = Stream.of(values())
            .collect(toMap(Winnings::getLottoRanking, Function.identity()));

    public static Winnings find(int correspondCount, int bonusCorrespondCount) {
        return rankToEnum.getOrDefault(LottoRanking.find(correspondCount, bonusCorrespondCount), MISS);
    }

    public enum LottoRanking {
        FIRST_PLACE(6, 0),
        SECOND_PLACE(5, 1),
        THIRD_PLACE(5, 0),
        FORTH_PLACE(4, 0),
        FIFTH_PLACE(3, 0),
        MISS_PLACE(0, 0);

        private int correspondCount;
        private int bonusCorrespondCount;

        LottoRanking(final int correspondCount, final  int bonusCorrespondCount) {
            this.correspondCount = correspondCount;
            this.bonusCorrespondCount = bonusCorrespondCount;
        }

        public int getCorrespondCount() {
            return this.correspondCount;
        }

        public int getBonusCorrespondCount() {
            return this.bonusCorrespondCount;
        }

        private boolean equal(int correspondCount, int bonusCorrespondCount) {
            return this.correspondCount == correspondCount && this.bonusCorrespondCount == bonusCorrespondCount;
        }

        public static LottoRanking find(int correspondCount, int bonusCorrespondCount) {
            return Arrays.stream(values())
                    .filter(r -> r.equal(correspondCount, bonusCorrespondCount))
                    .findFirst()
                    .orElse(MISS_PLACE);

        }
    }

}
