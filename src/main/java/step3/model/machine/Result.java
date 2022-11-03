package step3.model.machine;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import step3.model.value.Rule;

public enum Result {
    FIRST_PRIZE(6,Rule.DEFAULT_BONUS_COUNT, 2_000_000_000),

    SECOND_PRIZE_BONUS(5,Rule.BONUS_COUNT, 30_000_000),
    SECOND_PRIZE(5,Rule.DEFAULT_BONUS_COUNT, 1_500_000),
    THIRD_PRIZE(4,Rule.DEFAULT_BONUS_COUNT, 50_000),

    FOURTH_PRIZE(3,Rule.DEFAULT_BONUS_COUNT, 5_000),
    NO_PRIZE(0,Rule.DEFAULT_BONUS_COUNT, 0);


    private final int match;
    private final int bonusMatch;
    private final long prize;
    Result(int match, int bonusMatch, long prize) {
        this.match = match;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }



    public long getTotalPrize(int count){
        return prize*count;
    }
    public boolean isRewarded(){
        return prize>0;
    }

    public static Result getMatchResult(int matchCount, int bonusCount){
        if(isBonusMatching(matchCount, bonusCount)){
            return SECOND_PRIZE_BONUS;
        }
        return Stream.of(values())
                .filter(v->v.match==matchCount && v.bonusMatch==Rule.DEFAULT_BONUS_COUNT)
                .findAny()
                .orElse(NO_PRIZE);
    }
    private static boolean isBonusMatching(int matchCount, int bonusCount){
        return matchCount == Rule.BONUS_COUNT_NUMBER && bonusCount== Rule.BONUS_COUNT;
    }


    @Override
    public String toString() {
        return match+","+bonusMatch+","+ prize;
    }
}
