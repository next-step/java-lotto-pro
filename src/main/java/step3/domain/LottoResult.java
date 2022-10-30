package step3.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static final int MIN_CONTAIN_COUNT = 3;
    public static final int ZERO = 0;
    private Map<Integer, List<Lotto>> result;

    public LottoResult(){
        result = new HashMap<>();
    }
    public void addLottoResult(int containNumberCount, Lotto buy) {
        if(isValidateMinContainCount(containNumberCount)){
            return;
        }

        if(isResultNull(containNumberCount)){
            result.put(containNumberCount, new ArrayList<>());
        }
        result.get(containNumberCount).add(buy);
    }

    public int getResultCount(int containNumberCount) {
        if(isResultNull(containNumberCount)){
            return ZERO;
        }
        return result.get(containNumberCount).size();
    }

    private boolean isValidateMinContainCount(int containNumberCount){
        return containNumberCount < MIN_CONTAIN_COUNT;
    }

    private boolean isResultNull(int containNumberCount){
        return result.get(containNumberCount)==null;
    }
}
