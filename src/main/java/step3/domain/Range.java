package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step3.enums.Rule;

public class Range {

    private List<LottoNumber> range;

    public Range(int startNumber, int endNumber) {
        init(startNumber, endNumber);
    }

    private List<LottoNumber> init(int startNumber, int endNumber) {
        List<LottoNumber> initRangeList = new ArrayList<>();
        for (int i = startNumber; i <= endNumber; i++) {
            initRangeList.add(new LottoNumber(i));
        }
        this.range = initRangeList;
        return range;
    }

    public List<LottoNumber> getRandomSixNumbers() {
        Collections.shuffle(range);
        return range.subList(Rule.LOTTO_START_NUMBER.getRange(), Rule.LOTTO_END_NUMBER.getRange());
    }
}
