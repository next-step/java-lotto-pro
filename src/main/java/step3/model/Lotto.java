package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static List<LottoNumber> allNumbers;
    private List<LottoNumber> numbers;

    public static void initLottoNumberRangeList() {
        allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(new LottoNumber(i));
        }
    }

    public Lotto createLotto() {
        Collections.shuffle(allNumbers);
        this.numbers = allNumbers.subList(0, 6);
        return this;
    }

    public int getGeneratorLottoCount() {
        return numbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }
}
