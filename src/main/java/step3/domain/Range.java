package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Range {

    private List<Integer> range;

    public Range() {
    }

    public Range(int startNumber, int endNumber) {
        init(startNumber, endNumber);
    }

    public List<Integer> init(int startNumber, int endNumber) {
        List<Integer> initRangeList = new ArrayList<>();
        for (int i = startNumber; i <= endNumber; i++) {
            initRangeList.add(i);
        }
        this.range = initRangeList;
        return range;
    }

    public List<Integer> getRange() {
        return range;
    }
}
