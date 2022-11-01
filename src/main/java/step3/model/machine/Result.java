package step3.model.machine;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Result {
    FIRST_PRIZE(new Match(6,0), 2_000_000_000),

    SECOND_PRIZE_BONUS(new Match(5,1), 30_000_000),
    SECOND_PRIZE(new Match(5,0), 1_500_000),
    THIRD_PRIZE(new Match(4,0), 50_000),

    FOURTH_PRIZE(new Match(3,0), 5_000),
    NO_PRIZE(new Match(0,0), 0);

    private static final Map<Match, Result> matchResults = Stream.of(values())
            .collect(Collectors.toMap(Result::getMatch, Function.identity()));

    private final Match match;
    private final long prize;
    Result(Match match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    private Match getMatch(){
        return match;
    }

    public long getTotalPrize(int count){
        return prize*count;
    }
    public boolean isRewarded(){
        return prize>0;
    }

    public static Result getMatchResult(Match match){
        return matchResults.getOrDefault(match, NO_PRIZE);
    }

    @Override
    public String toString() {
        return match.toString()+","+ prize;
    }
}
