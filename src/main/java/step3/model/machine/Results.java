package step3.model.machine;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

    private final LinkedHashMap<Result, Integer> lottoResultMap;

    private static final int DEFAULT_RESULT_COUNT = 0;
    private static final int RESULT_INCREASE_STEP = 1;

    public Results() {
        lottoResultMap = new LinkedHashMap<>();
        for (Result result : Result.values()) {
            lottoResultMap.put(result, DEFAULT_RESULT_COUNT);
        }
    }

    public void recordResult(Result result) {
        lottoResultMap.put(result, lottoResultMap.get(result)+RESULT_INCREASE_STEP);

    }
    public int getResultCount(Result result){
        return lottoResultMap.get(result);
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
