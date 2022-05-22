package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNo {
    private final int lottoNo;

    public LottoNo(int no) {
        this.lottoNo = no;
    }

    public int value() {
        return lottoNo;
    }

    public static List<LottoNo> toLottoNoList(List<Integer> numbers) {
        Collections.sort(numbers);
        List<LottoNo> result = new ArrayList<>();
        for (int number : numbers){
            result.add(new LottoNo(number));
        }
        return result;
    }
}
