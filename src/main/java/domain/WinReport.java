package domain;

import java.util.HashMap;
import java.util.Map;

public class WinReport {

    private final Map<Integer, Integer> result = new HashMap<>();

    public void putLottoResult(int collectNumber){
        result.put(collectNumber, getLottoResult(collectNumber)+1);
    }

    public int getLottoResult(int collectNumber){
        return result.getOrDefault(collectNumber,0);
    }


}
