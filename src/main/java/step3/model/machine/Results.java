package step3.model.machine;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final LinkedHashMap<Result, Integer> lottoResultMap;

    public Results() {
        lottoResultMap = new LinkedHashMap<>();
        for (Result result : Result.values()) {
            lottoResultMap.put(result, 0);
        }
    }

    public void recordResult(List<Integer> matchCounts) {
        matchCounts.stream().map(Result::getMatchResult).forEach(
               result ->  lottoResultMap.put(result, lottoResultMap.get(result)+1)
        );

    }
    private long getTotalPrize(Result result) {
        int winningCount = lottoResultMap.get(result);
        return result.getTotalPrize(winningCount);
    }
    public long getWinningPrize() {
        return lottoResultMap.keySet().stream().mapToLong(this::getTotalPrize).sum();
    }

    public List<String> createStringOutput(){
        return lottoResultMap.keySet().stream()
                .filter(Result::isRewarded)
                .map(result -> result.toString()+","+lottoResultMap.get(result))
                .collect(Collectors.toList());
    }
}
