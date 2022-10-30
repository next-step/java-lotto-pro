package step3.model.machine;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Result {
    NO_PRIZE(2, 0),
    FOURTH_PRIZE(3, 5_000),
    THIRD_PRIZE(4, 50_000),
    SECOND_PRIZE(5, 1_500_000),
    FIRST_PRIZE(6, 2_000_000_000);
    private static final Map<Integer, Result> matchResults = Stream.of(values())
            .collect(Collectors.toMap(Result::getMatchCount, Function.identity()));

    private final int match;
    private final long prize;
    Result(int match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    private int getMatchCount(){
        return match;
    }
    public long getTotalPrize(int count){
        return prize*count;
    }
    public boolean isRewarded(){
        return prize>0;
    }

    public static Result getMatchResult(int match){
        return matchResults.getOrDefault(match, NO_PRIZE);
    }

}
