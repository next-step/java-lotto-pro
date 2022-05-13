package study.lotto.automatic.domain.draw;

import java.util.Map;

public class DrawResult {
    private final Map<Division, Long> divisionResult;

    public DrawResult(Map<Division, Long> divisionResult) {
        this.divisionResult = divisionResult;
    }

    public int numberOfWin(Division division) {
        return divisionResult.get(division).intValue();
    }

    public Map<Division, Long> get() {
        return divisionResult;
    }
}
