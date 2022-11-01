package step3.model;

import java.util.function.BiFunction;

public class RankFunction {

    private final BiFunction<Integer, Boolean, Boolean> matchFunction;
    private final int matchCount;

    public RankFunction(BiFunction<Integer, Boolean, Boolean> matchFunction,int matchCount){
        this.matchFunction = matchFunction;
        this.matchCount = matchCount;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public boolean isMatch(int matchCount,boolean isBonus){
        return matchFunction.apply(matchCount,isBonus);
    }
}
