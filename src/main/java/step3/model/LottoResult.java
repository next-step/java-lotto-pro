package step3.model;

import java.util.HashMap;
import java.util.Optional;

import static step3.constant.Constant.ZERO;

public class LottoResult {

    private HashMap<Integer, Integer> result = new HashMap<>();

    public void addResult(int sameCount) {
        if(isNotExistsCount(sameCount)) {
            result.put(sameCount, 0);
        }
        int count = result.get(sameCount);
        result.put(sameCount, ++count);
    }
    public boolean isNotExistsCount(int sameCount) {
        return result.get(sameCount) == null;
    }

    public String getResultValue(int winnerKey) {
        return Optional.ofNullable(result.get(winnerKey)).orElse(ZERO).toString();
    }
}
